package com.project0.movie.exception;

import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

//
public class ErrorDetails {
    private final LocalDate timeStamp;
    private final String message;
    private final String details;
    private final HttpStatus status;

    public ErrorDetails(LocalDate timeStamp, String message, String details, HttpStatus status) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
        this.status = status;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public HttpStatus getStatus(){
        return status;
    }
}
