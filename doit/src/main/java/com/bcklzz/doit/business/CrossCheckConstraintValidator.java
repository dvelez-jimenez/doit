package com.bcklzz.doit.business;

import javax.validation.ConstraintValidatorContext;



/**
 *
 * @author dvele
 */


public class CrossCheckConstraintValidator implements javax.validation.ConstraintValidator<CrossCheck, ValidEntity> {


    @Override
    public boolean isValid(ValidEntity value, ConstraintValidatorContext context) {
        return value.isValid();
    }

    @Override
    public void initialize(CrossCheck constraintAnnotation) {
    }
    
}
