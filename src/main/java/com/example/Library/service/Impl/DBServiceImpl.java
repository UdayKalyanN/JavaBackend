package com.example.Library.service.Impl;

import com.example.Library.domain.Book;
import com.example.Library.domain.Genre;
import com.example.Library.service.DBService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class DBServiceImpl //implements DBService
{

    //this preparedStatement is used to add book without effecting SQL Injection, Statement will give a chance for SQL Injection
//    private PreparedStatement addBookStatement=null;
//
//    @Autowired
//    private Connection connection;
//
//    @PostConstruct
//    public void init(){
//        log.info("Initializing DB Service"+connection);
//        log.info("creating table if not exists");
//        String query="create table if not exists books(bookId int primary key auto_increment, " +
//                "title varchar(255), author varchar(255), genre varchar(255), rating int, cost double, year int)";
//        try(Statement statement=connection.createStatement()){
//            statement.execute(query);
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//
//        try{
//            addBookStatement=connection.prepareStatement("insert into books(title,author,genre,rating,cost,year) values(?,?,?,?,?,?)");
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
//    }
////    @Override
//    // This method gives a chance to SQL Injection
////    public Book addBook(Book book) throws SQLException {
////        String query="insert into books(title,author,genre,rating,cost,year) values('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getGenre()+"','"+book.getRating()+"','"+book.getCost()+"','"+book.getYear()+"')";
////        Statement statement=null;
////        try(Statement statement1=connection.createStatement()){
////            statement1.execute(query);
////            log.info("Book added successfully");
////            return book;
////        }catch (SQLException e){
////            log.error("Error while adding book",e.getMessage());
//////            throw new RuntimeException(e);
////        }
////        return null;
////    }
//
//    @Override
//    public Book addBook(Book book) {
//        try{
//            addBookStatement.setString(1,book.getTitle());
//            addBookStatement.setString(2,book.getAuthor());
//            addBookStatement.setString(3,book.getGenre().toString());
//            addBookStatement.setDouble(4,book.getRating());
//            addBookStatement.setDouble(5,book.getCost());
//            addBookStatement.setInt(6,book.getYear());
//            addBookStatement.execute();
//            log.info("Book added successfully");
//        }catch (SQLException e){
//            log.error("Error while adding book",e.getMessage());
//            throw new RuntimeException(e);
//        }
//        return book;
//    }
//
//    @Override
//    public List<Book> getAllBooks() {
//        String query="select * from books";
//        try(Statement statement=connection.createStatement()){
//            ResultSet resultSet=statement.executeQuery(query);
//            List<Book> books=new ArrayList<>();
//            while(resultSet.next()){
//                Book book=new Book();
//                book.setBookId(resultSet.getString("bookId"));
//                book.setTitle(resultSet.getString("title"));
//                book.setAuthor(resultSet.getString("author"));
//                book.setGenre(Genre.valueOf(resultSet.getString("genre")));
//                book.setRating(resultSet.getDouble("rating"));
//                book.setCost(resultSet.getDouble("cost"));
//                book.setYear(resultSet.getInt("year"));
//                books.add(book);
//            }
//            return books;
//        } catch (SQLException e) {
//            log.error("Error getting book from DB: {}",e.getMessage());
//        }
//        return null;
//
//    }
}
