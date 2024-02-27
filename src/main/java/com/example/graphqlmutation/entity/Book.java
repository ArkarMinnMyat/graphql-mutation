package com.example.graphqlmutation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer pages;
    private String author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Review> reviews =
            new ArrayList<>();

    public void addReview(Review review){
        review.setBook(this);
        this.reviews.add(review);
    }

    public Book(String title, Integer pages, String author) {

        this.title = title;
        this.pages = pages;
        this.author = author;
    }
}
