package com.MyLibrary.library.controller;

import com.MyLibrary.library.security.exception.AuthorAlreadyExistException;
import com.MyLibrary.library.security.exception.BookAvailabilityException;
import com.MyLibrary.library.security.exception.BookLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseStatus(value= HttpStatus.CONFLICT)
    @ExceptionHandler(AuthorAlreadyExistException.class)
    public void handleAuthorAlreadyExistException(){}

    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason="Book is not available")
    @ExceptionHandler(BookAvailabilityException.class)
    public void handleBookAvailabilityException(){}

    @ResponseStatus(value= HttpStatus.CONFLICT, reason = "You reached book limit")
    @ExceptionHandler(BookLimitException.class)
    public void handleBookLimitException(){}

}
