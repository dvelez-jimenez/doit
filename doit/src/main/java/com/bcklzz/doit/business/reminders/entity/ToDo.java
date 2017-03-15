package com.bcklzz.doit.business.reminders.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@NamedQuery(name=ToDo.findAll, query="SELECT t FROM ToDo t")
@XmlRootElement(name = "todo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ToDo {
    
    @Id
    @GeneratedValue
    private long id;
    private String caption;
    private String description; 
    private int priority;
    
    
    static final String PREFIX = "doit.business.reminders.entity.";
    public static final String findAll = PREFIX + "findAll";

    public ToDo(){}
    
    public ToDo(String caption, String description, int priority) {
        this.caption = caption;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString(){
         return caption +"," + description+ "," + priority;
    }
    
    public long getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    
    
    
}
