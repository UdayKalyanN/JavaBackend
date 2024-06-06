package com.example.Library.controller;

import com.example.Library.domain.Book;
import com.example.Library.service.BookService;
import com.example.Library.service.DBService;
import com.example.Library.service.resource.BookRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class AdminController {
    @Autowired
    BookService bookService;

//    @Autowired
//   DBService dbService;

//    @Autowired
//    //@Qualifier("mysql")
//    private Connection connection;

//    @Autowired
//    @Qualifier("oracle")
//    private Connection oracleConnection;
    @PostMapping("/admin/book")
    public ResponseEntity<Book> createBook(@RequestBody @Valid BookRequest bookRequest) throws SQLException {

//        bookService.addBook(book);
        bookService.addBook(bookRequest.getBook());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin/book")
    public ResponseEntity<Book> updateBook(@RequestParam("BookId") String id,@RequestBody Book book){


        return new ResponseEntity<>(bookService.updateBook(id,book),HttpStatus.OK);
    }

    @DeleteMapping("/admin/book")
    public ResponseEntity<Book> deleteBook(@RequestParam("BookId") String id){

        bookService.deleteBook(Integer.valueOf(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/readoauth")
    public String readOauth(Authentication authentication) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.writeValueAsString(authentication);
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
