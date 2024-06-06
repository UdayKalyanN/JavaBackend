package com.example.Library.service.resource;

import com.example.Library.domain.Review;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {
    private String title;
    private String author;
    private Double cost;
    private Double rating;
    private List<Review> reviewList;

}
