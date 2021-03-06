package com.bcklzz.doit.business;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author dvele
 */

@Documented
@Constraint(validatedBy = CrossCheckConstraintValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CrossCheck {
    
   
    
    String message() default "crosscheck failure";
    
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
