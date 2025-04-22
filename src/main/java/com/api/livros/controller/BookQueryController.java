package com.api.livros.controller;

import com.api.livros.model.Book;
import com.api.livros.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BookQueryController {

    private final BookRepository bookRepository;

    @QueryMapping
    public Iterable<Book> allBooks() {
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book bookById(@Argument Long id) {
        return bookRepository.findById(id).orElseThrow( ()-> new RuntimeException("Resource not found"));
    }

    @QueryMapping
    public Iterable<Book> booksByAuthor(@Argument String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        return books != null ? books : Collections.emptyList();
    }
}
