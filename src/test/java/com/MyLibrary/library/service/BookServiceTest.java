package com.MyLibrary.library.service;

import com.MyLibrary.library.model.Book;
import com.MyLibrary.library.model.Hire;
import com.MyLibrary.library.repository.BookRepository;
import com.MyLibrary.library.repository.HireRepository;
import com.MyLibrary.library.security.exception.BookAvailabilityException;
import com.MyLibrary.library.security.exception.BookLimitException;
import com.MyLibrary.library.security.model.User;
import com.MyLibrary.library.security.service.UserHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
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

    @Mock
    HireService hireService;
    @Mock
    UserHelper userHelper;
    User user;
    Book book;
    Hire testHire1;
    Hire testHire2;
    Hire testHire3;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        book = new Book();
        book.setAvailable(true);
        book.setTitle("Title");
        book.setId(UUID.fromString("9785bb0c-5d71-4486-9731-55f69bdfaca2"));

        user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("testUserName");

        testHire1 = new Hire();
        testHire2 = new Hire();
        testHire3 = new Hire();
    }


    @Test
    public void isBookAvailable_book_available_test() {
        List<Hire> hires = new ArrayList<>();
        hires.add(testHire1);
        hires.add(testHire2);

        when(hireService.getUserHires()).thenReturn(hires);

        assertTrue(bookService.isBookAvailable(book));
    }

    @Test
    public void isBookAvailable_book_not_available() {
        book.setAvailable(false);

        assertThrows(BookAvailabilityException.class, () -> {
            bookService.isBookAvailable(book);
        });
    }

    @Test
    public void isBookAvailable_limit_reached() {
        List<Hire> hires = new ArrayList<>();
        hires.add(testHire1);
        hires.add(testHire2);
        hires.add(testHire3);

        when(hireService.getUserHires()).thenReturn(hires);

        assertThrows(BookLimitException.class, () -> {
            assertFalse(bookService.isBookAvailable(book));
        });
    }

    @Test
    public void createHire_test() {
        ArgumentCaptor<Hire> argumentCaptor = ArgumentCaptor.forClass(Hire.class);
        when(userHelper.getLoggedUser()).thenReturn(user);
        when(bookRepository.getBookById(any())).thenReturn(book);

        bookService.createHire(UUID.fromString("9785bb0c-5d71-4486-9731-55f69bdfaca2"));
        Mockito.verify(hireRepository).save(argumentCaptor.capture());

        assertEquals(book.getTitle(), argumentCaptor.getValue().getBook().getTitle());
        assertEquals(argumentCaptor.getValue().getUser().getUsername(), user.getUsername());
    }

}