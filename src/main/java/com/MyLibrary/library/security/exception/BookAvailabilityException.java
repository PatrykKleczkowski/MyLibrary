package com.MyLibrary.library.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BookAvailabilityException extends RuntimeException {
    public BookAvailabilityException(String msg) {
        super(msg);
    }


}
