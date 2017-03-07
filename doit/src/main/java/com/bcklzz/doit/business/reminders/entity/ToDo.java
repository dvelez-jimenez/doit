package com.bcklzz.doit.business.reminders.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ToDo {
    
    private String caption;
    private String description; 
    private int priority;

    public ToDo(String caption, String description, int priority) {
        this.caption = caption;
        this.description = description;
        this.priority = priority;
    }

    public ToDo() {
    }
    
    @Override
    public String toString(){
         return caption +"," + description+ "," + priority;
    }
    
    
}
