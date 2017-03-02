package com.bcklzz.doit.business.reminders.boundary;

import com.bcklzz.doit.business.reminders.entity.ToDo;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author daniel
 */
@Path("todos")
public class TodosResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo hello(){
        return new ToDo("implement REST endpoint", "...", 100);
    }
    
}
