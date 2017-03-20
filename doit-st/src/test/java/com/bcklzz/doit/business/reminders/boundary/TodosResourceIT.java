/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcklzz.doit.business.reminders.boundary;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author daniel
 */
public class TodosResourceIT {

    @Rule
    public JAXRSClientProvider provider = JAXRSClientProvider.buildWithURI("http://localhost:8080/doit/api/todos");
    
    
    public TodosResourceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void crud(){
        //create
        JsonObjectBuilder todoBuilder = Json.createObjectBuilder();
        JsonObject todoToCreate = todoBuilder
                                         .add("caption", "implement")
                                         .add("description", "...")
                                         .add("priority", 42)
                                         .build();
        
        Response post = this.provider.target().request(MediaType.APPLICATION_JSON).post(Entity.json(todoToCreate));
        String location = post.getHeaderString("Location");
        System.out.println("Location: "+location);
        assertThat(post.getStatus(), is(201));
        
        //read
        JsonObject dedicatedTodo = this.provider.target(location)
                                   .request(MediaType.APPLICATION_JSON)
                                   .get(JsonObject.class);
        
        assertTrue(dedicatedTodo.getString("caption").contains("implement"));
        
        //update
        JsonObjectBuilder updateBuilder = Json.createObjectBuilder();
        JsonObject todoToUpdate = updateBuilder
                                         .add("caption", "implemented")
                                         .build();
        Response put = this.provider.target(location).request(MediaType.APPLICATION_JSON).put(Entity.json(todoToUpdate));
        //String location = put.getHeaderString("Location");
        assertThat(put.getStatus(), is(204));
        
        JsonObject updatedTodo = this.provider.target(location)
                                 .request(MediaType.APPLICATION_JSON)
                                 .get(JsonObject.class);
        
        assertTrue(updatedTodo.getString("caption").contains("implemented"));
       
        
         //update status
        JsonObjectBuilder updateStatusBuilder = Json.createObjectBuilder();
        JsonObject todoToUpdateStatus = updateStatusBuilder
                                         .add("done", true)
                                         .build();
        Response statusUpdate = this.provider.target(location).path("status").request(MediaType.APPLICATION_JSON).put(Entity.json(todoToUpdateStatus));
        //String location = put.getHeaderString("Location");
        assertThat(statusUpdate.getStatus(), is(200));
        
        JsonObject updatedStatusTodo = this.provider.target(location)
                                       .request(MediaType.APPLICATION_JSON)
                                       .get(JsonObject.class);
        
        assertTrue(updatedStatusTodo.getBoolean("done"));
        
        
        
         //update status no existint
        JsonObjectBuilder updateNoExistingStatusBuilder = Json.createObjectBuilder();
        todoToUpdateStatus = updateNoExistingStatusBuilder
                                         .add("done", true)
                                         .build();
        statusUpdate = this.provider.target().path("-42").path("status").request(MediaType.APPLICATION_JSON).put(Entity.json(todoToUpdateStatus));
        //String location = put.getHeaderString("Location");
        assertThat(statusUpdate.getStatus(), is(400));
        
        
        
        //update bad request
        updateStatusBuilder = Json.createObjectBuilder();
        todoToUpdateStatus = updateStatusBuilder
                                               .add("wrong", true)
                                               .build();
        statusUpdate = this.provider.target(location).path("status").request(MediaType.APPLICATION_JSON).put(Entity.json(todoToUpdateStatus));
        //String location = put.getHeaderString("Location");
        assertThat(statusUpdate.getStatus(), is(400));
        
        
        
        //readAll
        Response response = this.provider.target().request(MediaType.APPLICATION_JSON).get();
        
        assertThat(response.getStatus(), is(200));
        
        JsonArray allTodos = response.readEntity(JsonArray.class);
        System.out.println("Payload: "+allTodos);
        assertFalse(allTodos.isEmpty());
        JsonObject todo = allTodos.getJsonObject(0);
        assertTrue(todo.getString("caption").startsWith("implement"));
        
        
        
        //delete
        Response delete = this.provider.target(location).request(MediaType.APPLICATION_JSON).delete();
        assertThat(delete.getStatus(), is(204));
    }
}
