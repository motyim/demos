package me.motyim.learn.mongodb.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Random;

import static com.mongodb.client.model.Filters.*;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 29-Oct-17
 */
public class ProjectionTest {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient();

        MongoDatabase db = mongoClient.getDatabase("course");

        MongoCollection<Document> collection = db.getCollection("projectionTest");

        collection.drop();

        for (int i = 0 ; i < 10 ; i++){
            collection.insertOne(new Document("x" , new Random().nextInt(2))
                                    .append("y", new Random().nextInt(10))
                                    .append("i" ,i));
        }


        Bson filter = and(eq("x",0) , gt("y",2) , lt("y",8));

        //Bson projection = new Document("x",0).append("_id",0);


//        Bson projection = Projections.exclude("x");         //exclude x
//        Bson projection = Projections.include("y","i");         //include only y, i
//        Bson projection = Projections.excludeId();              //exclude id can also by exclude("_id")

        //to exclude id and include y and i only
        Bson projection = Projections.fields(Projections.excludeId(),Projections.include("y","i"));

        ArrayList<Document> all = collection.find(filter).projection(projection).into(new ArrayList<Document>());
        long count = collection.count(filter);

        System.out.println("Number of found doc : "+count);
        System.out.println("------------------------------");
        for (Document doc: all) {
            Helper.printJson(doc);
        }

    }
}
