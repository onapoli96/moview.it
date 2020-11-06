package servlets;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.or;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Servlet implementation class RicercaFiltri
 */
@WebServlet("/RicercaFiltri")
public class RicercaFiltri extends HttpServlet {
	private static final long serialVersionUID1 = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RicercaFiltri() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		MongoDatabase database = Connection.getInstance();
		MongoCollection<Document> moviesCollection = database.getCollection("movies_details");
		ArrayList<Bson> componentiQuery = new ArrayList<Bson>();
		ArrayList<Film> risultati = new ArrayList<Film>();
		Bson ricercaCampiTxt;
		Bson ricercaPerIntervallo;
		Bson ricercaPerPaesi;
		Bson ricercaPerGeneri;

		System.out.println(request.getParameter("campoRicerca"));
		System.out.println(request.getParameter("anno1"));
		System.out.println(request.getParameter("anno2"));

		if(request.getParameter("campoRicerca")!=null && !request.getParameter("campoRicerca").equals("")) {
			String ricerca = (String)request.getParameter("campoRicerca");
			ricercaCampiTxt = or(eq("title",ricerca),
					in("countries",ricerca),
					in("genres",ricerca),
					eq("director",ricerca),
					in("writers",ricerca),
					in("actors",ricerca));
			componentiQuery.add(ricercaCampiTxt);
		}
		if(request.getParameter("anno1")!=null && !request.getParameter("anno1").equals("")) {
			int anno1 = Integer.parseInt(request.getParameter("anno1"));
			int anno2 = anno1;
			if(request.getParameter("anno2")!= null && !request.getParameter("anno2").equals("")){
				anno2 = Integer.parseInt(request.getParameter("anno2"));
				if(anno1 > anno2) {
					int temp = anno1;
					anno1 = anno2;
					anno2 = temp;
				}
			}
			ricercaPerIntervallo = and(gte("year",anno1),lte("year",anno2));
			componentiQuery.add(ricercaPerIntervallo);
		}		
		if(request.getParameter("paesi")!=null && request.getParameterValues("paesi").length >=1) {
			String[] paesi = request.getParameterValues("paesi");
			ricercaPerPaesi = in("countries", paesi);
			componentiQuery.add(ricercaPerPaesi);
		}		
		if(request.getParameter("generi")!=null && request.getParameterValues("generi").length >=1) {
			String[] generi = request.getParameterValues("generi");
			ricercaPerGeneri = in("genres", generi);
			componentiQuery.add(ricercaPerGeneri);
		}

		Bson filter = null;

		if(componentiQuery.size() >= 1) {
			filter = and(componentiQuery);
			for(Document document :  moviesCollection.find(filter)) {
				System.out.println(document);
			}
			risultati = lanciaQuery(moviesCollection,filter);
			request.setAttribute("films", risultati);
			RequestDispatcher dispatcher = getServletContext()
				      .getRequestDispatcher("/ricerca.jsp");
				    dispatcher.forward(request, response);
			//System.out.println(risultati);
		}
		Connection.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public  ArrayList<Film> lanciaQuery(MongoCollection<Document> collection, Bson filter) {
		ArrayList<Film> array = new ArrayList<Film>();
		for(Document document :  collection.find(filter)){
			Film film = new Film();
			if(document.get("title")!=null) {
				film.setTitolo((String)document.get("title"));
			}
			if(document.get("year")!=null) {
				try {
					film.setAnno(Double.toString((double)document.get("year")));
				}
				catch (Exception e) {
					film.setAnno(Integer.toString((int)document.get("year")));
				}

			}            
			if(document.get("rated")!=null) {
				film.setValutato((String)document.get("rated"));
			}
			film.setRilasciato("Unknown release date");
			if(document.get("released") != null) {
				film.setRilasciato((String)document.get("released").toString());
			}
			if(document.get("runtime") != null) {
				//film.setRuntime(Integer.toString((int)document.get("runtime")));
			}
			if(document.get("countries")!=null) {
				film.setPaesi((ArrayList<String>)document.get("countries"));
			}
			if(document.get("genres")!=null) {
				film.setGeneri((ArrayList<String>)document.get("genres"));
			}
			film.setDirettore("Unknow director");
			if(document.get("director")!=null) {
				film.setDirettore((String)document.get("director"));
			}
			if(document.get("writers")!=null) {
				film.setScrittori((ArrayList<String>)document.get("writers"));
			}
			if(document.get("actors")!=null) {
				film.setAttori((ArrayList<String>)document.get("actors"));
			}
			film.setTrama("Trama not found");
			if(document.get("plot")!=null) {
				film.setTrama((String)document.get("plot"));
			}
			film.setPoster("imgs/notfound.png");
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


			if(document.get("imdb")!=null) {
				//film.setImdb((String)document.get("imdb"));	
			}
			if(document.get("awards")!=null) {
				//film.setPremi((String)document.get("awards"));
			}
			if(document.get("type")!=null) {
				film.setType((String)document.get("type"));
			}
			array.add(film);
		}
		return array;

	}

}







