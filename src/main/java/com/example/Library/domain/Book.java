package com.example.Library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
@Entity
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Double cost;
    private Integer year;
    private Double rating;
    //private String authorEmail;
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("book")
    private List<Review> reviewList;

//    private List<Review> getReviewList() {
//        return reviewList;
//    }

//    public String toString(){
//        return "Book{" +
//                "Id=" + Id +
//                ", title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", genre=" + genre +
//                ", cost=" + cost +
//                ", year=" + year +
//                ", rating=" + rating +'\''+
//                ", reviewList=" + reviewList +
//                '}';
//    }


}
