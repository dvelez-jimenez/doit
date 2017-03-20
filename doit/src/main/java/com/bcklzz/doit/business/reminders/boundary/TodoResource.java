package com.bcklzz.doit.business.reminders.boundary;

import com.bcklzz.doit.business.reminders.entity.ToDo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author daniel
 */
public class TodoResource {
    
    
    long id;
    TodoManager manager;

    public TodoResource(long id, TodoManager manager) {
        this.id = id;
        this.manager = manager;
    }
    

    
    @GET
    public ToDo find(){
        return this.manager.findById(id);
    } 
    
    @DELETE
    public void delete(){
        this.manager.delete(id);
    }
    
    
    @PUT
    public void put(ToDo todo){
        todo.setId(id);
        this.manager.save(todo);
    }
    
    
    @PUT
    @Path("/status")
    public Response put(JsonObject status, @Context UriInfo info){
        if(!status.containsKey("done")){
            return Response.status(Response.Status.BAD_REQUEST).header("reason", "request should contain done field").build();
        }
        boolean done = status.getBoolean("done");
        
        ToDo todo = this.manager.updateStatus(id, done);
        if(todo == null){
            return Response.status(Response.Status.BAD_REQUEST).header("reason", "Todo with id "+id+" does not exist").build();
        }else{
            return Response.status(Response.Status.OK).entity(todo).build();
        }
    }
}
