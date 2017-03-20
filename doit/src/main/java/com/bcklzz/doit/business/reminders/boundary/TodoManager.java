 package com.bcklzz.doit.business.reminders.boundary;

import com.bcklzz.doit.business.reminders.entity.ToDo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dvele
 */

@Stateless
public class TodoManager {

    
    @PersistenceContext
    EntityManager em;
    
    public ToDo findById(long id) {
        return em.find(ToDo.class, id);
    }

    public void delete(long id) {
        try{
            ToDo reference = em.getReference(ToDo.class, id);
            em.remove(reference);
        }catch(EntityNotFoundException ex){
            //We want to delete the entity
        }
        
    }

    public List<ToDo> all() {
        return em.createNamedQuery(ToDo.findAll, ToDo.class).getResultList();
    }

    public ToDo save(ToDo todo) {
        return em.merge(todo);
    }

    public ToDo updateStatus(long id, boolean done) {
        ToDo todo = this.findById(id);
        if(todo != null){
            todo.setDone(done);
        }
        return todo;
    }

    
}
