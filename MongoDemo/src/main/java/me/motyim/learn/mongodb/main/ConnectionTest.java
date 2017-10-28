package me.motyim.learn.mongodb.main;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 28-Oct-17
 */
public class ConnectionTest {
    public static void main(String[] args) {
        //to connect to MongoDB
        //make a connection pool this step is optional
        MongoClientOptions mongoClientOptions = MongoClientOptions.builder().connectionsPerHost(100).build();

        //1. mongoClient  : default constructor use localhost and 27017 as port
        // MongoClient mongoClient = new MongoClient();

        //here we can use aslist to deal with cluster
        MongoClient mongoClient = new MongoClient(new ServerAddress("localhost",27017) ,mongoClientOptions);

        //2.get database
        MongoDatabase testDB = mongoClient.getDatabase("test").withReadPreference(ReadPreference.secondaryPreferred());

        //3.get collection
        MongoCollection<Document> testColl = testDB.getCollection("test");


    }
}
