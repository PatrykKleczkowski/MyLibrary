package com.MyLibrary.library.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class WrongOwnerException extends RuntimeException{

    public WrongOwnerException() {
        super("YOU ARE NOT THE OWNER");
    }

}
