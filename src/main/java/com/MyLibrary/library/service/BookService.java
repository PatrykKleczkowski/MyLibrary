package com.MyLibrary.library.service;

import com.MyLibrary.library.model.Book;
import com.MyLibrary.library.model.Hire;
import com.MyLibrary.library.model.dto.EditedBookDTO;
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

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BookService {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private UserHelper userHelper;
    private HireRepository hireRepository;

    @Autowired
    public BookService(AuthorRepository authorRepository, BookRepository bookRepository, UserHelper userHelper, HireRepository hireRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.userHelper = userHelper;
        this.hireRepository = hireRepository;
    }




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

    @Transactional
    public Hire returnBook(Long hireId) {
        Hire hire = hireRepository.getOne(hireId);
        if (hire.getUser().getId() != userHelper.getLoggedUser().getId()) {
            throw new WrongOwnerException();
        }

        hire.setHireDateTo(new Date());
        hire.getBook().setAvailable(true);
        bookRepository.save(hire.getBook());
        return hireRepository.save(hire);
    }

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books;
    }


    public Book editBook(EditedBookDTO editedBookDTO) {
        Book book = bookRepository.getOne(editedBookDTO.getBookId());
        book.setAuthor(authorRepository.getOne(editedBookDTO.getAuthorId()));
        book.setTitle(editedBookDTO.getTitle());
        book.setReleaseDate(editedBookDTO.getReleaseDate());

       return bookRepository.save(book);

    }

}
