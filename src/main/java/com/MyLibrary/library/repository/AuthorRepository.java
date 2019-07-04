package com.MyLibrary.library.repository;

import com.MyLibrary.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getOneById(UUID id);
    Author getAuthorByLastName(String lastName);

    boolean existsAuthorByLastName(String username);


}
