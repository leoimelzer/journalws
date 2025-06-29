package com.journal.journalws.util.common;

import jakarta.validation.ConstraintViolation;

public class FieldViolation {

    private final String property;
    private final String message;

    public FieldViolation(ConstraintViolation<?> violation) {
        this.property = violation.getPropertyPath().toString();
        this.message = violation.getMessage();
    }

    @SuppressWarnings("unused")
    public String getProperty() {
        return property;
    }

    @SuppressWarnings("unused")
    public String getMessage() {
        return message;
    }

}
