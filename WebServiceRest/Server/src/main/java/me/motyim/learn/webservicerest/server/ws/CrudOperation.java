/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.motyim.learn.webservicerest.server.ws;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import me.motyim.learn.webservicerest.server.Person;
import me.motyim.learn.webservicerest.server.Service;

/**
 * @author MotYim <mohamed.motyim@gmail.com>
 * @since Mar 2, 2018
 */
@Path("/person")
public class CrudOperation {

    Service service;
    
    private static final Logger LOG = Logger.getLogger(CrudOperation.class.getName());
    
    

    public CrudOperation() {
        service = new Service();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        LOG.info("access get all users");
        List<Person> persons = service.get().collect(Collectors.toList());
        LOG.info("get all users");
        return Response.ok(persons).build();
    }
}
