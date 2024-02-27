package com.example.graphqlmutation.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String comment;
    @ManyToOne
    private Book book;

    public Review(String title, String comment) {
        this.title = title;
        this.comment = comment;
    }

    public Review() {

    }
}
