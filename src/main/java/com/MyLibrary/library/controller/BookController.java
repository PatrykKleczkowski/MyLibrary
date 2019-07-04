package com.MyLibrary.library.controller;

import com.MyLibrary.library.model.dto.EditedBookDTO;
import com.MyLibrary.library.model.dto.NewBookDTO;
import com.MyLibrary.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/books/rentBook/{bookId}")
    public ResponseEntity<?> rentBook(@PathVariable("bookId") UUID bookId) {
        bookService.rentBook(bookId);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/books/returnBook/{id}")
    public ResponseEntity<?> returnBook(@PathVariable("id") UUID hireId) {
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
    public ResponseEntity<?> editBook(@RequestBody EditedBookDTO editedBookDTO) {
        return ResponseEntity.ok(this.bookService.editBook(editedBookDTO));
    }

}
