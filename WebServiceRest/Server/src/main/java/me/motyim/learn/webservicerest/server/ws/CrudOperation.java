package me.motyim.learn.webservicerest.server.ws;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import me.motyim.learn.webservicerest.dto.Person;
import me.motyim.learn.webservicerest.server.Respons;
import me.motyim.learn.webservicerest.server.Service;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 2, 2018
 */
@Path("/person")
public class CrudOperation {

    private static final Service SERVICE = new Service();

    private static final Logger LOG = Logger.getLogger(CrudOperation.class.getName());

    //https://stackoverflow.com/questions/5392413/jersey-return-a-list-of-strings
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GenericEntity<List<Person>> getAll() {
        LOG.info("access get all users");
        List<Person> persons = SERVICE.get().collect(Collectors.toList());
        LOG.info("get all users");
        return new GenericEntity<List<Person>>(persons) {
        };
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Person getPerson(@PathParam("id") int id) {
        return SERVICE.get(id).orElse(new Person());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Respons<Boolean> addPerson(Person person){
        LOG.info("user added");
        return new Respons<>(SERVICE.add(person));
    }
    
    
    @DELETE
    @Path("/{id}")
    public Respons<Boolean> deletePerson(@PathParam("id") int id ){
        return new Respons<>(SERVICE.remove(id));
    }
    
    @PUT
    @Path("/{id}")
    public Respons<Boolean> updatePerson(@PathParam("id") int id,Person person){
        return new Respons<>(SERVICE.update(id, person));
    }
}
