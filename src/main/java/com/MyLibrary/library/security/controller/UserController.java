package com.MyLibrary.library.security.controller;


import com.MyLibrary.library.security.model.UserCredentials;
import com.MyLibrary.library.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users/signup")
    public ResponseEntity<?> saveUser(@RequestBody UserCredentials userCredentials) {
        userService.createUser(userCredentials);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
