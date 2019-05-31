package com.MyLibrary.library.controller;

import com.MyLibrary.library.model.dto.NewBookDTO;
import com.MyLibrary.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RepositoryRestController
public class BookController {

    @Autowired
    private BookService bookService;


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/books/addBook")
    public ResponseEntity<?> addBook(@RequestBody NewBookDTO newBookDTO) {
        bookService.addBook(newBookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')") //TODO ZMIENIC TYLKO NA USER
    @PutMapping("/books/rentBook")
    public ResponseEntity<?> rentBook(@RequestParam("id") Long bookId){
        bookService.rentBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')") //TODO ZMIENIC TYLKO NA USER
    @PutMapping("/books/returnBook")
    public ResponseEntity<?> returnBook(@RequestParam("id") Long bookId){
        bookService.returnBook(bookId);
        return ResponseEntity.ok().build();
    }

}
