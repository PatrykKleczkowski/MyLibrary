package com.MyLibrary.library.controller;

import com.MyLibrary.library.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@RepositoryRestController
public class HireController {

    @Autowired
    private HireService hireService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @GetMapping("/hires/getHires")
    public ResponseEntity<?> getBorrowedBooks() {
        return ResponseEntity.ok(this.hireService.getUserHires());
    }


}
