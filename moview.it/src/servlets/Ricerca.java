package servlets;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.lte;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class Ricerca
 */
@WebServlet("/Ricerca")
public class Ricerca extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Ricerca() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoDatabase database = Connection.getInstance();
    
		
        MongoCollection<Document> moviesCollection = database.getCollection("movies_details");
        Bson filter = and(gt("year",2008),lte("year",2010)); 
      
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String json = new Gson().toJson(lanciaQuery(moviesCollection, filter));
        response.getWriter().write(json);
      
 
        Connection.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public  List<String> lanciaQuery(MongoCollection<Document> collection, Bson filter) {
		
		List<String> array = new ArrayList<String>();
		for(Document document :  collection.find(filter)){
			Film film = new Film();
            film.setTitolo((String)document.get("title"));
            //film.setAnno(Integer.toString((int)document.get("year")));
            film.setValutato((String)document.get("rated"));
            if(document.get("released") != null) {
            	film.setRilasciato((String)document.get("released").toString());
            }
            if(document.get("runtime") != null) {
            	//film.setRuntime(Integer.toString((int)document.get("runtime")));
            }
            film.setPaesi((ArrayList<String>)document.get("countries"));
            film.setGeneri((ArrayList<String>)document.get("genres"));
            film.setDirettore((String)document.get("director"));
            film.setScrittori((ArrayList<String>)document.get("writers"));
            film.setAttori((ArrayList<String>)document.get("actors"));
            film.setTrama((String)document.get("plot")); 
            
            if((String)document.get("poster")!=null) {
        	String newString = "";
        	String poster= (String)document.get("poster");
    		for (int i = 0; i < poster.length(); i++) { 
                newString += poster.charAt(i); 
                if (i == 3) { 
                    newString += "s"; 
                } 
            } 
    		
            film.setPoster(newString);
            }
            //film.setImdb((String)document.get("imdb"));
            //film.setPremi((String)document.get("awards"));
            film.setType((String)document.get("type"));
            
            String json = new Gson().toJson(film);
            
            array.add(json);
		}
		return array;
	}

}
