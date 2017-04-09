package com.bcklzz.doit.business.reminders.entity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dvele
 */


public class ToDoTest {
    
    public ToDoTest() {
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

   

    /**
     * Test of isDone method, of class ToDo.
     */
    @Test
    public void testIsDone() {
        System.out.println("isDone");
        ToDo instance = new ToDo();
        boolean expResult = false;
        boolean result = instance.isDone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDone method, of class ToDo.
     */
    @Test
    public void testSetDone() {
        System.out.println("setDone");
        boolean done = true;
        ToDo instance = new ToDo();
        instance.setDone(done);
        assertTrue(instance.isDone());
    }

    /**
     * Test of isValid method, of class ToDo.
     */
    @Test
    public void testInvalidTodo() {
        System.out.println("testInvalidTodo");
        ToDo instance = new ToDo("caption", "", 11);
        System.out.println("Instance isValid:"+ instance.isValid());
        assertFalse(instance.isValid());
    }
    
    @Test
    public void testTodoWithoutDescription() {
        System.out.println("testTodoWithoutDescription");
        ToDo instance = new ToDo("caption", null, 10);
        System.out.println("Instance isValid:"+ instance.isValid());
        assertTrue(instance.isValid());
    }
    
        /**
     * Test of isValid method, of class ToDo.
     */
    @Test
    public void testValidTodo() {
        System.out.println("testValidTodo");
        ToDo instance = new ToDo("caption", "description", 10);
        System.out.println("Instance isValid:"+ instance.isValid());
        assertTrue(instance.isValid());
    }
    
    
}
