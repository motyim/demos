package me.motyim.learn.mongodb.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 28-Oct-17
 */
public class FindTest {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();

        MongoDatabase db = mongoClient.getDatabase("course");

        MongoCollection<Document> coll = db.getCollection("findTest");

        coll.drop();

        //insert some record in db
        for (int i = 0; i < 10; i++) {
            coll.insertOne(new Document("x" , i));
        }


        //find one
        Document first = coll.find().first();
        System.out.println("Find one : ");
        Helper.printJson(first);


        //find all with into
        ArrayList<Document> all =coll.find().into(new ArrayList<Document>());
        System.out.println("\nFind all With into : ");
        for (Document doc: all) {
            Helper.printJson(doc);
        }


        //find all with iteration
        System.out.println("\nFind all with iteration : ");
        MongoCursor<Document> iterator = coll.find().iterator();
        try{ //to handle if exception occur
            while(iterator.hasNext())
                Helper.printJson(iterator.next());
        }finally {
            iterator.close();
        }


        //count
        System.out.println("Count : ");
        long count = coll.count();
        System.out.println("num of Doc = " + count);
    }
}
