package com.MyLibrary.library.security.exception;

public class BookLimitException extends RuntimeException {


    public BookLimitException(){
        super("Book limit");
    }
}
