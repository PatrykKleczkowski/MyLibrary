package com.MyLibrary.library.service;

import com.MyLibrary.library.model.Author;
import com.MyLibrary.library.model.dto.NewAuthorDTO;
import com.MyLibrary.library.repository.AuthorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public Author addAuthor(NewAuthorDTO newAuthorDTO){
        Author author = new Author();
        BeanUtils.copyProperties(newAuthorDTO, author);

       return authorRepository.save(author);
    }
}
