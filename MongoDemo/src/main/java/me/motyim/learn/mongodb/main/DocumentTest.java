package me.motyim.learn.mongodb.main;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 28-Oct-17
 * this class to test create document
 */
public class DocumentTest {

    public static void main(String[] args) {

        Document document = new Document()
                            .append("str","String")
                            .append("int",123)
                            .append("bool",false)
                            .append("double",12.3)
                            .append("date",new Date())
                            .append("_id" ,new ObjectId())
                            .append("nested" , new Document("name","mohamed"))
                            .append("list" , Arrays.asList(1,2,3));

        Helper.printJson(document);
    }
}
