package com.example.graphqlmutation.controller;

import com.example.graphqlmutation.entity.Book;
import com.example.graphqlmutation.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @QueryMapping
    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }
}
