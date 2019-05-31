package com.MyLibrary.library.controller;

import com.MyLibrary.library.model.dto.NewAuthorDTO;
import com.MyLibrary.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RepositoryRestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/authors/addAuthor")
    public ResponseEntity<?> addAuthor(@RequestBody NewAuthorDTO newAuthorDTO){
        authorService.addAuthor(newAuthorDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }



}
