/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bcklzz.doit.business.reminders.boundary;

import com.airhacks.rulz.jaxrsclient.JAXRSClientProvider;
import javax.json.JsonArray;
import javax.json.JsonObject;
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
    public void postAndFetch(){
        String xml = "<todo>\n" +
                         "<caption>implement</caption>\n" +
                         "<description>...</description>\n" +
                         "<priority>100</priority>\n" +
                      "</todo>\n";
        Response post = this.provider.target().request(MediaType.APPLICATION_XML).post(Entity.xml(xml));
        String location = post.getHeaderString("Location");
        System.out.println("Location: "+location);
        assertThat(post.getStatus(), is(201));
        
        JsonObject dedicatedTodo = this.provider.target(location)
                                   .request(MediaType.APPLICATION_JSON)
                                   .get(JsonObject.class);
        
        assertTrue(dedicatedTodo.getString("caption").contains("implement"));
        
    }

    @Test
    public void fetchAll() {
       
        Response response = this.provider.target().request(MediaType.APPLICATION_JSON).get();
        
        assertThat(response.getStatus(), is(200));
        
        JsonArray allTodos = response.readEntity(JsonArray.class);
        System.out.println("Payload: "+allTodos);
        assertFalse(allTodos.isEmpty());
        JsonObject todo = allTodos.getJsonObject(0);
        assertTrue(todo.getString("caption").startsWith("implement"));
    }
        
    @Test
    public void delete(){
        Response delete = this.provider.target().path("42").request(MediaType.APPLICATION_JSON).delete();
        assertThat(delete.getStatus(), is(204));
    }
    

}
