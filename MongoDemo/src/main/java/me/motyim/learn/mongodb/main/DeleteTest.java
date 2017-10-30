package me.motyim.learn.mongodb.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 30-Oct-17
 */
public class DeleteTest {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();

        MongoDatabase db = mongoClient.getDatabase("course");

        MongoCollection<Document> collection = db.getCollection("deleteTest");

        collection.drop();

        for (int i = 0; i < 5; i++) {
            collection.insertOne(new Document("_id",i));
        }

        collection.deleteMany(Filters.gt("_id",3));

        ArrayList<Document> docs = collection.find().into(new ArrayList<Document>());

        for (Document doc : docs) {
            Helper.printJson(doc);
        }
    }
}
