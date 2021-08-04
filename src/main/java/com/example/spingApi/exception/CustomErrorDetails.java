package com.example.spingApi.exception;

import java.util.Date;

public class CustomErrorDetails {
    private Date date;
    private String message;
    private String errorMessage;

    public CustomErrorDetails(Date date, String message, String errorMessage) {
        this.date = date;
        this.message = message;
        this.errorMessage = errorMessage;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
