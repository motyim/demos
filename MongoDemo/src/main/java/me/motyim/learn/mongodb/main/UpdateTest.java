package me.motyim.learn.mongodb.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.*;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 30-Oct-17
 */
public class UpdateTest {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();

        MongoDatabase db = mongoClient.getDatabase("course");

        MongoCollection<Document> collection = db.getCollection("updateTest");

        collection.drop();

        for (int i = 0; i < 5; i++) {
            collection.insertOne(new Document("_id",i).append("x",i).append("y",true));
        }

//        collection.replaceOne(eq("x",3),new Document("x",20).append("update",true));

//        collection.updateOne(eq("x",3),new Document("$set",new Document("x",20).append("update",true)));

//        collection.updateOne(eq("x",3), Updates.set("x",20));

//        collection.updateOne(eq("x",3), Updates.combine(Updates.set("x",20),Updates.set("updated",true)));

//        collection.updateOne(eq("_id",20), Updates.set("x",20),new UpdateOptions().upsert(true));

        collection.updateMany(gte("x",2),Updates.inc("x",1));

        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());

        for (Document doc : docs) {
            Helper.printJson(doc);
        }
    }
}
