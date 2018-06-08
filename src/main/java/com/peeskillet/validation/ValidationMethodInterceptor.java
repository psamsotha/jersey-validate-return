package com.peeskillet.validation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class ValidationMethodInterceptor implements MethodInterceptor {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object retValue = invocation.proceed();

        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(retValue);

        if (!constraintViolations.isEmpty()) {
            throw new ResponseValidationException(constraintViolations);
        }
        return retValue;
    }
}
