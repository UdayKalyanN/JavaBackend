package com.example.Library.controller;

import com.example.Library.domain.Book;
import com.example.Library.domain.Review;
import com.example.Library.exception.UserAlreadyExistedException;
import com.example.Library.service.BookService;
import com.example.Library.service.DBService;
import com.example.Library.service.UserService;
import com.example.Library.service.resource.BookResponse;
import com.example.Library.service.resource.UserRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    BookService bookService;

//    @Autowired
   // DBService dbService;

    @Autowired
    UserService userService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(),HttpStatus.OK);
    }

//    @GetMapping("/book")
//    public ResponseEntity<Set<Book>> getAllBooks(){
//        System.out.println("Get All books Api getting called");
//        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
//    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") String BookId){
        return new ResponseEntity<>(bookService.getBook(Integer.valueOf(BookId)),HttpStatus.OK);
    }

    @PostMapping("/{bookId}/review")
    public ResponseEntity<Review> addReview(@PathVariable("bookId") String bookId, @RequestBody Review review){
        return new ResponseEntity<>(bookService.addReview(Integer.valueOf(bookId),review),HttpStatus.CREATED);
    }

    @PostMapping("register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRequest userRequest) throws UserAlreadyExistedException {

        userService.addUser(userRequest.toUser());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    // Used to get the csrf token from Server
    @GetMapping("/csrf")
    public String homePage(HttpServletRequest request){
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        System.out.println(csrfToken.getToken());
        return csrfToken.getToken();

    }
}
