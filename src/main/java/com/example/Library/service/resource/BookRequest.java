package com.example.Library.service.resource;

import com.example.Library.domain.Book;
import com.example.Library.domain.Genre;
import com.example.Library.domain.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.Builder;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @NotBlank(message = "Author cannot be blank")
    private String author;
    private Genre genre;
    @Min(value=0, message = "cost cannot be less than 0")
    private Double cost;
    @Min(value=1000, message = "year cannot be less than 1000")
    private Integer year;
    private Double rating;

    public Book getBook() {
        return Book.builder()
                .title(this.title)
                .author(this.author)
                .genre(this.genre)
                .cost(this.cost)
                .year(this.year)
                .rating(0.0)
                .build();
    }
}
