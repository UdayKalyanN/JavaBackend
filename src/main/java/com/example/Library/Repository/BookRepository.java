package com.example.Library.Repository;

import com.example.Library.domain.Book;
import com.example.Library.domain.Genre;
import org.antlr.v4.runtime.ListTokenSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Adding Custom Query
   List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    List<Book> findByGenre(Genre genre);
    List<Book> findByCost(Double cost);

    List<Book> findByYear(Integer year);
    List<Book> findByAuthorAndGenre(String author, Genre genre);
//
//    List<Book> findByAuthorAndYear(String author,Integer year);
//
   // List<Book> findByTitleAndAuthor(String title,String author);
//
   // List<Book> findByTitleGroupByAuthor(String title);

    List<Book> findByGenreOrderByCost(Genre genre, Sort sort);

    @Query("SELECT b FROM Book b WHERE b.cost > 90.0")
    List<Book> giveMeCheapBooks();

    @Query(value = "select * from books where rating >= ?1", nativeQuery = true)
    List<Book> giveMeTopBooks(Double rating);

    List<Book> findByTitleOrAuthor(String title, String author);

    List<Book> findByTitleLike(String title);



    Page<Book> findByGenre(Genre genre, Pageable pageable);
}
