 package com.bcklzz.doit.business.reminders.boundary;

import com.bcklzz.doit.business.reminders.entity.ToDo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author dvele
 */

@Stateless
public class TodoManager {

    public ToDo findById(long id) {
        return new ToDo("implement REST endpoint "+id, "...", 100);
    }

    public void delete(long id) {
        System.out.println("Deleted todo "+id);
    }

    public List<ToDo> all() {
        List<ToDo> allTodos = new ArrayList<>();
        allTodos.add(findById(42));
        return allTodos;
    }

    public void save(ToDo todo) {
        System.out.println("Saving todo: "+todo.toString());
    }

    
}
