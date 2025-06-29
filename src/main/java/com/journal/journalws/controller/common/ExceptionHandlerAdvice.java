package com.journal.journalws.controller.common;

import com.journal.journalws.exception.common.ApiException;
import com.journal.journalws.util.common.FieldViolation;
import com.journal.journalws.util.common.ResponseError;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ResponseError> handleApiException(
            ApiException ex,
            HttpServletRequest request
    ) {
        System.out.println("Handlando ApiException lá no advice");
        final HttpStatus status = HttpStatus.BAD_REQUEST;
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
        System.out.println("Handlando ConstraintViolationException lá no advice");
        final HttpStatus status = HttpStatus.BAD_REQUEST;
        final String path = request.getRequestURI();
        final List<FieldViolation> message = ex.getConstraintViolations().stream().map(FieldViolation::new).toList();

        ResponseError body = new ResponseError(status, path, message);

        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleException(
            Exception ex,
            HttpServletRequest request
    ) {
        System.out.println("Handlando Exception lá no advice");
        final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        final String path = request.getRequestURI();
        final String message = ex.getMessage();

        ResponseError body = new ResponseError(status, path, message);

        return ResponseEntity.status(status).body(body);
    }

}
