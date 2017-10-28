package me.motyim.learn.mongodb.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Random;

import static com.mongodb.client.model.Filters.*;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 28-Oct-17
 */
public class FindWithFilterTest {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();

        MongoDatabase db = mongoClient.getDatabase("course");

        MongoCollection <Document> collection = db.getCollection("findWithFilter");

        collection.drop();

        //insert random data
        for (int i = 0; i < 10; i++) {
            collection.insertOne(new Document()
                    .append("x" , new Random().nextInt(2))
                    .append("y", new Random().nextInt(10)));
        }

//        Bson filter = new Document("x",0)
//                    .append("y",new Document("$gt",3).append("$lt",8));

        //apply filter
        Bson filter = and(eq("x",0),gt("y",2),lt("y",8));


        ArrayList <Document> all = collection.find(filter).into(new ArrayList<Document>());
        long count = collection.count(filter);



        System.out.println("Count is : " + count );
        System.out.println("----------------------");
        for (Document doc:all) {
            Helper.printJson(doc);
        }

    }
}
