package com.journal.journalws.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseError {

    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String path;
    private final Object message;

    public ResponseError(HttpStatus status, String path, Object message) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.path = path;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    @SuppressWarnings("unused")
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @SuppressWarnings("unused")
    public int getStatus() {
        return status;
    }

    @SuppressWarnings("unused")
    public String getError() {
        return error;
    }

    @SuppressWarnings("unused")
    public String getPath() {
        return path;
    }

    @SuppressWarnings("unused")
    public Object getMessage() {
        return message;
    }

}
