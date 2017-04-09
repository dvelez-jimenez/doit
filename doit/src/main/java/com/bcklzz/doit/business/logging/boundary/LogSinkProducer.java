package com.bcklzz.doit.business.logging.boundary;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author dvele
 */


public class LogSinkProducer {
    
    @Produces
    public LogSink produce(InjectionPoint ip){
        Class<?> declaringClass = ip.getMember().getDeclaringClass();
        return Logger.getLogger(declaringClass.getName())::info;
    }
}
