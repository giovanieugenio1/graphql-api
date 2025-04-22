package com.api.livros.controller;

import com.api.livros.model.Book;
import com.api.livros.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class BookController {

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
    public Iterable<Book> booksByAuhor(@Argument String author) {
        return bookRepository.findByAuthor(author);
    }
}
