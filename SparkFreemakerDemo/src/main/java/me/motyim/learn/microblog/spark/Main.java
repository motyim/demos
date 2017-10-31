package me.motyim.learn.microblog.spark;

import freemarker.template.Configuration;
import freemarker.template.Template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

/**
 * @author MA MotYim <mohamed.motyim@gmail.com>
 * @since 18-Oct-17
 */

public class Main {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Project Start");


        get("/" ,(req,res)->{
            return "hello to home page .. see project to understand logic";
        });


        //handel get request
        get("/hello", (req, res) -> {

            //setup free maker configeration
            Configuration configuration = new Configuration();
            configuration.setClassForTemplateLoading(FreeMakerTest.class,"/");

            StringWriter sw = new StringWriter();

            try {
                Template page = configuration.getTemplate("hello.fm");

                Map<String,Object> map = new HashMap<>();
                map.put("user","motyim");

                page.process(map , sw);

            } catch (Exception e) {
                halt(500);  // make spark send error 500
                e.printStackTrace();
            }
            return sw;
        });

        // send param in link
        get("/test/:name" , (request, response) -> "welcome to test " + request.params(":name"));


        //make a form to test post request
        get("/color",(request, response) -> {
            logger.info("enter color request");
            //setup free maker configeration
            Configuration configuration = new Configuration();
            configuration.setClassForTemplateLoading(FreeMakerTest.class,"/");

            StringWriter sw = new StringWriter();


            try {
                Template colorFormPage = configuration.getTemplate("form.html");

                Map<String,Object> map = new HashMap<>();
                map.put("colors", Arrays.asList("red","green" , "yellow","blue"));

                colorFormPage.process(map , sw);

            } catch (Exception e) {
                halt(500);  // make spark send error 500
                e.printStackTrace();
            }


            return sw ;
        });

        post("test_color" ,(request, response) -> {
            final String color = request.queryParams("color");
            if(color == null){
                return "please choose color";
            }else{
                return "you choose a "+color+ " color";
            }
        });


    }
}
