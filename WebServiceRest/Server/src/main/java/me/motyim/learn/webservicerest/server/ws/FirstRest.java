package me.motyim.learn.webservicerest.server.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import me.motyim.learn.webservicerest.server.Respons;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 1, 2018
 */
@Path("/frist")
public class FirstRest {

    @GET
    public String first() {
        return "hello Rest";
    }

    @GET
    @Path("query")
    public String sayHello(@QueryParam("name") String name) {
        return "hello " + name;
    }

    //https://stackoverflow.com/questions/16408950/jax-rs-jersey-getinteger-class-and-single-json-primitive-integer-values
    @GET
    @Path("/sum/{number1}/{number2}")
    @Produces(MediaType.APPLICATION_JSON)
    public Respons<Integer> test(@PathParam("number1") int number1, @PathParam("number2") int number2) {
        return new Respons<>(number2 + number1);
    }

//    @GET
//    @Path("/sum2/{number1}/{number2}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public GenericEntity<Integer> sum2(@PathParam("number1") int number1, @PathParam("number2") int number2) {
//       Integer a = number1+number2;
//        GenericEntity<Integer> aa = new GenericEntity<>(a){};
//        return null;
//    }

}
