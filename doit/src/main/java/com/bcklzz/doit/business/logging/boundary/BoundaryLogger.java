package com.bcklzz.doit.business.logging.boundary;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author dvele
 */


public class BoundaryLogger {
    
    @Inject
    LogSink LOG;
    
    @AroundInvoke
    public Object logCall(InvocationContext ic) throws Exception{
        LOG.log(""+ic.getMethod());
        return ic.proceed();
    }
}
