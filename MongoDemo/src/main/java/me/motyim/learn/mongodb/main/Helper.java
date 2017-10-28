package me.motyim.learn.mongodb.main;

import org.bson.Document;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonWriter;


import java.io.StringWriter;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since 28-Oct-17
 */
public class Helper {

    public static void printJson(Document document){
        JsonWriter jsonWriter = new JsonWriter(new StringWriter());
        new DocumentCodec().encode(jsonWriter,document, EncoderContext.builder().isEncodingCollectibleDocument(true).build());
        System.out.println(jsonWriter.getWriter());
        System.out.flush();
    }
}
