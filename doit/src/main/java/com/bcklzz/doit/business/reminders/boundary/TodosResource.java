package com.bcklzz.doit.business.reminders.boundary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author daniel
 */
@Path("todos")
public class TodosResource {
    
    @GET
    public String hello(){
        return "Hello "+System.currentTimeMillis();
    }
    
}
