package com.example.Library.service.resource;


import com.example.Library.domain.Book;
import com.example.Library.domain.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    @NotBlank(message = "comment cannot be blank")
    private String comment;
    @Min(value = 0, message = "rating cannot be less than zero")
    @Max(value = 5, message = "rating cannot be greater than 5")
    private Double rating;
    @Min(value = 0, message = "bookId cannot be blank")
    private Integer bookId;

    public Review toReview(){


        return Review.builder().comment(this.comment).rating(this.rating)
                .book(Book.builder().Id(this.bookId).build()).build();
    }

}
