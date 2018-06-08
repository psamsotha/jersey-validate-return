package com.peeskillet.validation;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ResponseValidationException extends RuntimeException {

    private final Set<ConstraintViolation<Object>> violations;

    public ResponseValidationException(Set<ConstraintViolation<Object>> violations) {
        this.violations = violations;
    }

    public Set<ConstraintViolation<Object>> getViolations() {
        return this.violations;
    }
}
