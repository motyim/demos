package me.motyim.learn.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import javax.ws.rs.core.MediaType;
import me.motyim.learn.webservicerest.dto.Person;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 3, 2018
 */
public class RestClient {

    public static void main(String[] args) {

        Client client = Client.create();

        //GET Request
        WebResource webResource = client.resource("http://localhost:8084/Server/rest/person/1");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Error ::: " + response.getStatus());
        }

        //to be able to get it into dto must add jersey-json
        Person person = response.getEntity(Person.class);

        System.out.println("Output from Server .... \n");
        System.out.println(person);

        //--------------------------------------------------------
        //Post Request
        WebResource webResourcePost = client.resource("http://localhost:8084/Server/rest/person");

        String postJson = "{\"age\":\"25\",\"id\":\"5\",\"name\":\"MA motyim\"}";
        webResourcePost.accept(MediaType.APPLICATION_JSON).post(ClientResponse.class,postJson);
        
    }

}
