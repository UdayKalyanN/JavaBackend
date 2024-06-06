package com.example.Library;

import com.example.Library.Repository.BookRepository;
import com.example.Library.domain.Book;
import com.example.Library.domain.Genre;
import com.example.Library.domain.Review;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.csrf.CsrfToken;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Value("${a}")
	Integer a=2;
	@Autowired
	ApplicationContext context;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	HttpServletRequest request;

	@Override
	public void run(String... args) throws Exception {
		Book book = new Book();
		book.setTitle("Title1");
		book.setAuthor("Author2");
		book.setGenre(Genre.CHILDREN);
		book.setCost(50.0);
		book.setYear(2020);
		book.setRating(4.5);
		List<Review> reviewList = new ArrayList<>();
		reviewList.add(new Review());


		//bookRepository.save(book);

		redisTemplate.opsForValue().set("key", "value");
		System.out.println(redisTemplate.opsForValue().get("key"));

		redisTemplate.opsForList().rightPush("list", 1);
		redisTemplate.opsForList().rightPush("list", 2);
		redisTemplate.opsForList().rightPush("list", 3);
		redisTemplate.opsForList().leftPush("list", 0);
		redisTemplate.opsForList().rightPush("list",4);

		System.out.println(redisTemplate.opsForList().leftPop("list"));
		System.out.println(redisTemplate.opsForList().leftPop("list"));
		System.out.println(redisTemplate.opsForList().rightPop("list"));
		System.out.println(book.getTitle());
		String title = book.getTitle();
		redisTemplate.opsForHash().put("hash", title, book);

//		for(String beanName : context.getBeanDefinitionNames()){
//			System.out.println(beanName);
//		}
//		System.out.println(a);
////		Book book = new Book();
////		book.setTitle("Book2");
////		book.setAuthor("Author2");
////		book.setGenre(Genre.CHILDREN);
////		book.setCost(75.0);
////		book.setYear(2008);
////		book.setRating(5.5);
//		bookRepository.save(book);

//		List<Book> bookList = bookRepository.findAll();
//
//		for (Book books : bookList) {
//			System.out.println(books.getTitle() + " " + books.getAuthor() + " " + books.getGenre() + " " + books.getCost() + " " + books.getYear());
//		}
//
//		List<Book> topBooks = bookRepository.giveMeTopBooks(5.0);
//		System.out.println("TOP BOOKS");
//		for (Book books : topBooks) {
//			System.out.println(books.getTitle() + " " + books.getAuthor() + " " + books.getGenre() + " " + books.getCost() + " " + books.getYear());
//		}
//
//		List<Book> bookTitleLike = bookRepository.findByTitleLike("%1%");
//		System.out.println("BOOKS BY TITLE LIKE");
//		for (Book books : bookTitleLike) {
//			System.out.println(books.getTitle() + " " + books.getAuthor() + " " + books.getGenre() + " " + books.getCost() + " " + books.getYear());
//		}
//
//		Page<Book> bookByGenre = bookRepository.findByGenre(Genre.NONFICTION,Pageable.ofSize((2)));
//		System.out.println("BOOKS BY GENRE Using Page");
//		for (Book books : bookByGenre) {
//			System.out.println(books.getTitle() + " " + books.getAuthor() + " " + books.getGenre() + " " + books.getCost() + " " + books.getYear());
//		}
//
//		List<Book> bookByGenreAndAuthor = bookRepository.findByAuthorAndGenre("Author1", Genre.NONFICTION);
//		System.out.println("BOOKS BY AUTHOR AND GENRE");
//		for (Book books : bookByGenreAndAuthor) {
//			System.out.println(books.getTitle() + " " + books.getAuthor() + " " + books.getGenre() + " " + books.getCost() + " " + books.getYear());
//		}
//
//		List<Book> bookByAuthor = bookRepository.findByAuthor("Author1");
//		System.out.println("BOOKS BY AUTHOR");
//		for (Book books:bookByAuthor){
//			System.out.println(books.getTitle()+" "+books.getAuthor());
//		}
//		bookList=bookRepository.findByGenre(Genre.NONFICTION);
//		bookList=bookRepository.findByCost(200.0);
//		List<Book> bookTitle=bookRepository.findByTitle("Book4");
//		System.out.println("BOOKS BY TITLE");
//		for(Book books:bookTitle){
//			System.out.println(books.getTitle());
//		}
//		List<Book> cheapBooks = bookRepository.giveMeCheapBooks();
//		List<Book> topBooks2 = bookRepository.findByGenreOrderByCost(Genre.NONFICTION, Sort.by(Sort.Direction.DESC, "cost"));
//		System.out.println("Cheap BOOKS");
//		for(Book books:cheapBooks){
//			System.out.println(books.getTitle()+" "+books.getAuthor()+" "+books.getGenre()+" "+books.getCost()+" "+books.getYear());
//		}
//		System.out.println("Order by cost");
//		for(Book books:topBooks2){
//			System.out.println(books.getTitle()+" "+books.getAuthor()+" "+books.getGenre()+" "+books.getCost()+" "+books.getYear());
//		}

	}
}
