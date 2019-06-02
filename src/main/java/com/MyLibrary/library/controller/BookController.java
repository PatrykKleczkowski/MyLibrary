package com.MyLibrary.library.controller;

import com.MyLibrary.library.model.Book;
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
    @GetMapping("/books/rentBook/{bookId}")
    public ResponseEntity<?> rentBook(@PathVariable("bookId") Long bookId) {
        bookService.rentBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')") //TODO ZMIENIC TYLKO NA USER
    @GetMapping("/books/returnBook/{id}")
    public ResponseEntity<?> returnBook(@PathVariable("id") Long hireId) {
        bookService.returnBook(hireId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/books/getAll")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(this.bookService.getAllBooks());
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/books/edit")
    public ResponseEntity<?> editBook(@RequestBody Book book) {
        return ResponseEntity.ok(this.bookService.editBook(book));
    }

}
