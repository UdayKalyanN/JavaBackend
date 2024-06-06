package com.example.Library.service.impl;

import com.example.Library.Repository.BookRepository;
import com.example.Library.Repository.ReviewRepository;
import com.example.Library.domain.Book;
import com.example.Library.domain.Review;
import com.example.Library.service.BookService;
import com.example.Library.service.resource.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

//    private final Map<Integer, Book> bookMap = new ConcurrentHashMap<>();
//    private final AtomicInteger bookIdCounter = new AtomicInteger(1);
//    private final AtomicInteger reviewIdCounter = new AtomicInteger(1);
    BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    ReviewRepository reviewRepository;


    @Override
    public void addBook(Book book) {
////        int bookId = bookIdCounter.getAndIncrement();
////        book.setBookId(String.valueOf(bookId));
////        bookMap.put(bookId, book);
//        int bookId = Integer.parseInt(String.valueOf(book.getBookId()));
//        book.setBookId(Integer.valueOf(String.valueOf(bookId)));
//        bookMap.put(bookId, book);

        bookRepository.save(book);

    }
    // Manual mapping to other entities with Response
//    @Override
//    public List<BookResponse> getAllBooks() {
////        return new HashSet<>(bookMap.values());
//
//        List<Book> Books=bookRepository.findAll();
//        List<BookResponse> bookResponses=new ArrayList<BookResponse>();
//        for(Book book1:Books){
//            List<Review> reviews=reviewRepository.findByBookId(book1.getBookId());
//            bookResponses.add(BookResponse.builder().cost(book1.getCost()).title(book1.getTitle()).author(book1.getAuthor()).
//                    rating(book1.getRating()).reviewList(reviews).build());
//        }
//        return bookResponses;
//    }

    @Override
    public List<Book> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        if(bookList.isEmpty()){
            throw new IllegalStateException("No Books Found");
        }
        return bookList;
    }

    @Override
    public Book getBook(Integer id) {
//        return bookMap.get(id);
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBook(Integer id) {
//        bookMap.remove(id);
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(String bookId, Book book) {
//        int id = Integer.parseInt(bookId);
//        if (bookMap.containsKey(id)) {
//            book.setBookId(Integer.valueOf(bookId));
//            bookMap.put(id, book);
//            return book;
//        }
//        return null;
        Optional<Book> book1 = bookRepository.findById(Integer.parseInt(bookId));
        if(book1.isPresent()){
            book.setId(Integer.parseInt(bookId));
            bookRepository.save(book);
            return book;
        }
        return null;
    }

    @Override
    public Review addReview(Integer bookId, Review review) {
//        Book book = bookMap.get(bookId);
//        if (book != null) {
////            int reviewId = reviewIdCounter.getAndIncrement();
////            review.setReviewId(String.valueOf(reviewId));
////            book.getReviewList().add(review);
////            return review;
//        }
       return null;
    }

    public List<Review> getReviewsByBookId(Integer bookId) {
        return reviewRepository.findReviewsByBookId(bookId);
    }


}
