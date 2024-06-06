package com.example.Library.service;

import com.example.Library.domain.Book;
import com.example.Library.domain.Review;
import com.example.Library.service.resource.BookResponse;

import java.util.List;
import java.util.Set;


public interface BookService {

    public void addBook(Book book);
    public List<Book> getAllBooks();
    public Book getBook(Integer Id);

    public void deleteBook(Integer Id);
    public Book updateBook(String id,Book book);

    public Review addReview(Integer bookId, Review review);



}
