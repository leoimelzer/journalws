package com.journal.journalws.controller;

import com.journal.journalws.dto.FieldViolation;
import com.journal.journalws.dto.ResponseError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleException(
            Exception ex,
            HttpServletRequest request
    ) {
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        final String path = request.getRequestURI();
        final String message = ex.getMessage();

        ResponseError body = new ResponseError(status, path, message);

        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseError> handleConstraintViolationException(
            ConstraintViolationException ex,
            HttpServletRequest request
    ) {
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        final String path = request.getRequestURI();
        final List<FieldViolation> message = ex.getConstraintViolations().stream().map(FieldViolation::new).toList();

        ResponseError body = new ResponseError(status, path, message);

        return ResponseEntity.status(status).body(body);
    }

}
