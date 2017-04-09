package com.bcklzz.doit.business.logging.boundary;

/**
 *
 * @author dvele
 */

@FunctionalInterface
public interface LogSink {
    void log(String msg);
}
