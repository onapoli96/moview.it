package servlets;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.conversions.Bson;
public class MongoClientTest {
	public static void main(String[] args) {
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("movies");
        for (String name : database.listCollectionNames()) {
            System.out.println(name);
        }
        
        MongoCollection<Document> moviesCollection = database.getCollection("movies");
        
        for(org.bson.Document document :  moviesCollection.find()){
        	System.out.println(document);
        }
        /*
            $gt=greater than
			$lt=less than
			$eq=equal
			$ne=not equal
         */
        Document condition = new Document("$eq", 2008);
        Bson filter = new Document("year", condition);
        for(Document document :  moviesCollection.find(filter)){
            System.out.println(document.getString("title"));
        }
       
        
        mongoClient.close();
    }
}