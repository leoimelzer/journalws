package com.journal.journalws.exception.common;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
