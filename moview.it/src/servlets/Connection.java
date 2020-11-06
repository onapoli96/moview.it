package servlets;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connection {
	private static  MongoDatabase database;
	private static  MongoClient mongoClient;
	
	private Connection() {}
	
	public static MongoDatabase getInstance() {
		if (database == null)
		{ 
	        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
			mongoLogger.setLevel(Level.SEVERE);
			mongoClient = new MongoClient("localhost", 27017);
	        database = mongoClient.getDatabase("movies");
		}
		return database; 
	}
	
	public static void closeConnection() {
		if (database != null && mongoClient != null )
		{ 
	        mongoClient.close();
	        mongoClient = null;
	        database = null;
		}
	}
}
