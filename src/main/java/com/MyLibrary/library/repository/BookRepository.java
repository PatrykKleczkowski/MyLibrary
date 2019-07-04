package com.MyLibrary.library.repository;

import com.MyLibrary.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {

    Book getBookByTitle(String title);
    Book getBookById(UUID id);

}
