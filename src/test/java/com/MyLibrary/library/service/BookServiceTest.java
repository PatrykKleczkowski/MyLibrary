package com.MyLibrary.library.service;

import com.MyLibrary.library.model.Book;
import com.MyLibrary.library.repository.BookRepository;
import com.MyLibrary.library.repository.HireRepository;
import com.MyLibrary.library.security.exception.BookAvailabilityException;
import com.MyLibrary.library.security.model.User;
import com.MyLibrary.library.security.service.UserHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
class BookServiceTest {

    @InjectMocks
    BookService bookService;
    @Mock
    BookRepository bookRepository;
    @Mock
    HireRepository hireRepository;

    @InjectMocks
    HireService hireService;
    @Mock
    UserHelper userHelper;
    User user;
    Book book;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        book = new Book();
        book.setAvailable(true);
        book.setTitle("Title");
        user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUserName");
    }

    @Test
    public void rentBook_book_not_available_test() {
        Book book = new Book();
        book.setId(UUID.randomUUID());
        book.setAvailable(false);
        when(bookRepository.getBookById(any())).thenReturn(book);

        assertThrows(BookAvailabilityException.class, () -> {
            bookService.rentBook(book.getId());
        });
    }

    @Test
    public void rentBook_book_available_test() {

    }

    @Test
    public void createHire_test() {

    }

}