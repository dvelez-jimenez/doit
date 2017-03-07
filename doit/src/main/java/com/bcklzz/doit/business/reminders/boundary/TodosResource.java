package com.bcklzz.doit.business.reminders.boundary;

import com.bcklzz.doit.business.reminders.entity.ToDo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author daniel
 */
@Path("todos")
@Stateless
public class TodosResource {
    
    
    @Inject
    TodoManager manager;
    
    @GET
    public List<ToDo> all(){
        return this.manager.all();
    }
    
    @GET
    @Path("{id}")
    public ToDo find(@PathParam("id") long id){
        return this.manager.findById(id);
    } 
    
    @POST
    public void save(ToDo todo){
        this.manager.save(todo);
        
    }
    
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id){
        this.manager.delete(id);
    }
}
