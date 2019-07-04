package com.MyLibrary.library.security.exception;

public class AuthorAlreadyExistException extends RuntimeException {
    public AuthorAlreadyExistException() {
        super("Author already exist");
    }
}
