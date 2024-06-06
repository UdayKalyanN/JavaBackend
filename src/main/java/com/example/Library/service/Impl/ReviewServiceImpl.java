package com.example.Library.service.Impl;

import com.example.Library.Repository.BookRepository;
import com.example.Library.Repository.ReviewRepository;
import com.example.Library.domain.Book;
import com.example.Library.domain.Review;
import com.example.Library.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void addReview(Review review) {

        Optional<Book> book = bookRepository.findById(review.getBook().getId());
        if(book.isEmpty()){
            throw new IllegalArgumentException("BookId not found");
        }else{
            review.setBook(book.get());
        }
        reviewRepository.save(review);
    }
}
