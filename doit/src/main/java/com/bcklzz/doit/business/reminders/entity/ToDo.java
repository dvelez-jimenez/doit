package com.bcklzz.doit.business.reminders.entity;

import com.bcklzz.doit.business.CrossCheck;
import com.bcklzz.doit.business.ValidEntity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@CrossCheck
public class ToDo implements ValidEntity {
    
    @Id
    @GeneratedValue
    private long id;
    
    @NotNull
    @Size(min = 1, max = 256)
    private String caption;
    private String description; 
    private int priority;
    private boolean done;
    
    @Version
    private long version;


    
    
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public boolean isValid() {
        if(this.priority <= 10){ return true; }
        return (this.description != null && this.description.length() > 0);
    }
}
