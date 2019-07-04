package com.MyLibrary.library.service;

import com.MyLibrary.library.model.Author;
import com.MyLibrary.library.model.dto.NewAuthorDTO;
import com.MyLibrary.library.repository.AuthorRepository;
import com.MyLibrary.library.security.exception.AuthorAlreadyExistException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public Author addAuthor(NewAuthorDTO newAuthorDTO){
        Author author = authorRepository.getAuthorByLastName(newAuthorDTO.getLastName());
        if(author != null){
            throw new AuthorAlreadyExistException();
        }

        Author newAuthor = new Author(newAuthorDTO.getFirstName(), newAuthorDTO.getLastName());
       return authorRepository.save(newAuthor);
    }
}
