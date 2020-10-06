package servlets;

import java.util.ArrayList;
import java.util.List;
 
import org.bson.Document;
 
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
 
public class Util {
 
    private static MongoDatabase getConnection() {
        int port_no = 27017;
        String url = "localhost";
        MongoClient mongoClntObj = new MongoClient(url, port_no);
        String db_name = "movies";
        MongoDatabase db = mongoClntObj.getDatabase(db_name);
        return db;
    }
 
}