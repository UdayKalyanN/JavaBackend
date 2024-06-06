package com.example.Library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
@Builder
public class Review {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String comment;
   // private String reviewer;
    private Double rating;
    //private Integer bookId;

    @ManyToOne
    @JsonIgnoreProperties("reviewList")
    @JoinColumn(name = "book_Id")
    private Book book;

}
