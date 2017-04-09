 package com.bcklzz.doit.business;

import javax.ejb.EJBException;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author dvele
 */

@Provider
public class EJBExceptionMapper implements ExceptionMapper<EJBException> {

    @Override
    public Response toResponse(EJBException exception) {
        Throwable cause = exception.getCause();
        Response response;
        if(cause instanceof OptimisticLockException){
           response = Response.status(Response.Status.CONFLICT).header("cause", "conflict: "+cause).build();
        }else{
           response = Response.serverError().header("cause", exception.toString()).build();
        }
        
        return response;
    }
    
}
