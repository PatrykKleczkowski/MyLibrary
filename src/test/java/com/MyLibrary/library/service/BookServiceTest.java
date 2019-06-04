package com.MyLibrary.library.service;

import com.MyLibrary.library.model.Book;
import com.MyLibrary.library.repository.BookRepository;
import com.MyLibrary.library.repository.MockHireRepository;
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
    MockHireRepository mockHireRepository;

    @InjectMocks
    HireService hireService;
    @Mock
    UserHelper userHelper;
    User user;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new User();
        user.setId(new Long(123));
    }

    @Test
    public void rentBook_book_not_available_test() {
        Book book = new Book();
        book.setAvailable(false);
        when(bookRepository.getOne(any())).thenReturn(book);

        assertThrows(BookAvailabilityException.class, () -> {
            bookService.rentBook(new Long(1));
        });
    }

}