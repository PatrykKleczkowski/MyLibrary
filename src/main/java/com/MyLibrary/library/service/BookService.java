package com.MyLibrary.library.service;

import com.MyLibrary.library.model.Book;
import com.MyLibrary.library.model.Hire;
import com.MyLibrary.library.model.dto.NewBookDTO;
import com.MyLibrary.library.repository.AuthorRepository;
import com.MyLibrary.library.repository.BookRepository;
import com.MyLibrary.library.repository.HireRepository;
import com.MyLibrary.library.security.exception.BookAvailabilityException;
import com.MyLibrary.library.security.exception.WrongOwnerException;
import com.MyLibrary.library.security.service.UserHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserHelper userHelper;
    @Autowired
    private HireRepository hireRepository;


    public Book addBook(NewBookDTO newBookDTO) {
        Book book = new Book();
        book.setAuthor(authorRepository.getOne(newBookDTO.getAuthorId()));
        BeanUtils.copyProperties(newBookDTO, book);

        return bookRepository.save(book);
    }

    public Hire rentBook(Long bookId) {
        Book book = bookRepository.getOne(bookId);
        if (!book.isAvailable()) {
            throw new BookAvailabilityException("Book is not available");
        }
        Hire hire = new Hire();

        hire.setBook(book);
        hire.setHireDateFrom(new Date());
        hire.setUser(userHelper.getLoggedUser());

        book.setAvailable(false);
        return hireRepository.save(hire);
    }

    public Hire returnBook(Long bookId) {
        Book book = bookRepository.getOne(bookId);
        if (book.getAuthor().getId() != userHelper.getLoggedUser().getId()) {
            throw new WrongOwnerException();
        }
        if (book.isAvailable()) {
            throw new BookAvailabilityException("Book is available");
        }

        Hire hire = hireRepository.getHireByBook_Id(bookId);
        hire.setHireDateTo(new Date());
        book.setAvailable(true);
        return hireRepository.save(hire);
    }

}
