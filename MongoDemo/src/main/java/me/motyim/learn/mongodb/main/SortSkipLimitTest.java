package me.motyim.learn.mongodb.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 30-Oct-17
 */
public class SortSkipLimitTest {

    public static void main(String[] args) {


        MongoClient mongoClient = new MongoClient();

        MongoDatabase db = mongoClient.getDatabase("course");

        MongoCollection<Document> collection = db.getCollection("SortSkipLimitTest");

        collection.drop();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                collection.insertOne(new Document().append("i",i).append("j",j));
            }
        }


        Bson projection = Projections.excludeId();

        // 1 : asc , -1 : dec
//        Bson sort = new Document().append("i",1).append("j",-1);

//        Sorts.ascending("i","j");
//        Sorts.descending("j");

        Bson sort = Sorts.orderBy(Sorts.ascending("i"),Sorts.descending("j"));

        ArrayList<Document> data = collection.find()
                                             .projection(projection)
                                             .sort(sort)
                                             .limit(10)
                                             .skip(2)  //skip only first 2 element
                                             .into(new ArrayList<Document>());

        for (Document doc :data) {
            Helper.printJson(doc);
        }
    }
}
