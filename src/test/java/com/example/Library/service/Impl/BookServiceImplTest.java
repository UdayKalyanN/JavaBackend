package com.example.Library.service.Impl;

import com.example.Library.Repository.BookRepository;
import com.example.Library.domain.Book;
import com.example.Library.service.BookService;
import org.junit.jupiter.api.Test;
import com.example.Library.service.impl.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceImplTest {

    @Test
    void TestGetAllBooks() {
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        //Mocking
        BookRepository bookRepository = mock(BookRepository.class);
        bookServiceImpl.setBookRepository(bookRepository);

        //Stubbing
        List<Book> bookList = new ArrayList<>();
        Book book =new Book();
        bookList.add(book);
        //mockito
        when(bookRepository.findAll()).thenReturn(bookList);

        bookServiceImpl.getAllBooks();

    }

    @Test
    void testGetAllBooks_EmptyList() {
        BookServiceImpl bookServiceImpl = new BookServiceImpl();
        //Mocking
        BookRepository bookRepository = mock(BookRepository.class);
        bookServiceImpl.setBookRepository(bookRepository);

        //Stubbing
        List<Book> bookList = new ArrayList<>();
        //mockito
        when(bookRepository.findAll()).thenReturn(bookList);
        assertThrows(IllegalStateException.class, bookServiceImpl::getAllBooks);

    }
}