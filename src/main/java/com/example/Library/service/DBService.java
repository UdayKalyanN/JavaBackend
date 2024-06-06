package com.example.Library.service;

import com.example.Library.domain.Book;
import org.w3c.dom.stylesheets.LinkStyle;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DBService {

   public Book addBook(Book book) throws SQLException;

   public List<Book> getAllBooks();
}
