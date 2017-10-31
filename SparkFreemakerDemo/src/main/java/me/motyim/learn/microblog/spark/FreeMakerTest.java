package me.motyim.learn.microblog.spark;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MA MotYim <mohamed.motyim@gmail.com>
 * @since 18-Oct-17
 */
public class FreeMakerTest {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(FreeMakerTest.class,"/");

        try {
            Template hello = configuration.getTemplate("hello.fm");
            StringWriter sw = new StringWriter();
            Map<String,Object> map = new HashMap<>();
            map.put("user","motyim");

            hello.process(map , sw);

            System.out.println(sw);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
