package servlets;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.BsonDocument;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;

public class ModificaDataset {

	public static void main(String[] args) {
		MongoDatabase database = Connection.getInstance();
		MongoCollection<Document> movies = database.getCollection("movies_details");
		MongoCollection<Document> reviews = database.getCollection("movies_reviews");
		
		for(Document document :  movies.find()){
			String id = (String) document.get("_id").toString();
			String title = (String) document.get("title");
			ArrayList<String> review = new ArrayList<String>();
			String pattern = ".*" + title.replace('*', ' ') + ".*";
			for(Document d :  reviews.find(regex("text", pattern, "i"))){
				String idReviews = (String) d.get("_id").toString();
				review.add(idReviews);
			}
			addReviews(movies, id, review);
		}
	}
	
	public static  void addReviews(MongoCollection<Document> collection, String idUpdate, ArrayList<String> id) {
		Document query = new Document();
        query.append("_id",new ObjectId(idUpdate));
        Document setData = new Document();
        
        setData.append("reviews", id);
        Document update = new Document();
        update.append("$set", setData);
        
        collection.updateOne(query, update);
	}
	
}
