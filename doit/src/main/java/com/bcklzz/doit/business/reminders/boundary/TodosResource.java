package com.bcklzz.doit.business.reminders.boundary;

import com.bcklzz.doit.business.reminders.entity.ToDo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.validation.Valid;
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
@Path("todos")
@Stateless
public class TodosResource {
    
    
    @Inject
    TodoManager manager;
    
    @Path("{id}")
    public TodoResource getTodoResource(@PathParam("id") long id){
        return new TodoResource(id, manager);
    }
    
    @GET
    public List<ToDo> all(){
        return this.manager.all();
    }
      
    @POST
    public Response save(@Valid ToDo todo, @Context UriInfo info){
        ToDo saved = this.manager.save(todo);
        URI uri = info.getAbsolutePathBuilder().path("{id}").build(saved.getId());        
        return Response.created(uri).build();
    }
    
}
