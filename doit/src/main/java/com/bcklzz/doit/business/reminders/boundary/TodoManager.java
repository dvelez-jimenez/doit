 package com.bcklzz.doit.business.reminders.boundary;

import com.bcklzz.doit.business.reminders.entity.ToDo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
        ToDo reference = em.getReference(ToDo.class, id);
        em.remove(reference);
    }

    public List<ToDo> all() {
        return em.createNamedQuery(ToDo.findAll, ToDo.class).getResultList();
    }

    public void save(ToDo todo) {
        em.merge(todo);
    }

    
}
