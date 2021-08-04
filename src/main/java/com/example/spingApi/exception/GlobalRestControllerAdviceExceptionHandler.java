package com.example.spingApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

//@RestControllerAdvice
public class GlobalRestControllerAdviceExceptionHandler {

    @ExceptionHandler(FirstNameNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final CustomErrorDetails handleFirstNameNotFound(FirstNameNotFoundException ex){
        CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), "From @RestControllerAdvice - First name not found", ex.getMessage());
        return customErrorDetails;
    }
}
