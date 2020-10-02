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
 
    public static boolean searchUserInDb(String loginId, String loginPwd) {
        boolean user_found = false;
 
        // Get the mongodb connection
        MongoDatabase db = getConnection();
 
        // Get the mongodb collection.
        MongoCollection col = db.getCollection(db_collection_name);
 
        // Get the particular record from the mongodb collection        
        List obj = new ArrayList();
        obj.add(new BasicDBObject("id", loginId));
        obj.add(new BasicDBObject("pwd", loginPwd));
 
        // Form a where query
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("$and", obj);
        System.out.println("Sql query is?= " + whereQuery.toString());
 
        FindIterable cursor = col.find(whereQuery);
        for(Document doc : cursor) {
            System.out.println("Found?= " + doc);
            user_found = true;
        }
        return user_found;
    }
}