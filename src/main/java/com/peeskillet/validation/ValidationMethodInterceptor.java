package com.peeskillet.validation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.core.Response;
import java.util.Set;


public class ValidationMethodInterceptor implements MethodInterceptor {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object retValue = invocation.proceed();
        if (retValue instanceof Response) {
            // if return value is Response
            return validateEntity(((Response) retValue).getEntity());
        } else {
            // if return value is the entity.
            return validateEntity(retValue);
        }
    }

    private Object validateEntity(Object entity) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(entity);
        if (!constraintViolations.isEmpty()) {
            throw new ResponseValidationException(constraintViolations);
        }
        return entity;
    }
}
