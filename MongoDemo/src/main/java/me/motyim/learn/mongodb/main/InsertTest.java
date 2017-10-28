package me.motyim.learn.mongodb.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;


/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 28-Oct-17
 */
public class InsertTest {

    public static void main(String[] args) {

        // connect through default option
        MongoClient mongoClient = new MongoClient();

        //connect to database
        MongoDatabase db = mongoClient.getDatabase("course");

        //connect to collection
        MongoCollection<Document> coll = db.getCollection("insertTest");

        //to rest database
        coll.drop();


        Document doc = new Document()
                .append("name","mohamed")
                .append("age",24)
                .append("language", Arrays.asList("JAVA","PHP"));

        Document doc2 = new Document()
                .append("name","mostafa")
                .append("age",23)
                .append("language", Arrays.asList("JAVA","C#"));


        //print doc before insert
        Helper.printJson(doc);

        coll.insertMany(Arrays.asList(doc,doc2));


        //print doc after insert get an id from server
        Helper.printJson(doc);
    }

}
