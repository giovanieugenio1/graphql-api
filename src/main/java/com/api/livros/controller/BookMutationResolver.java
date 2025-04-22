package com.api.livros.controller;

import com.api.livros.model.Book;
import com.api.livros.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class BookMutationResolver {

    private final BookRepository bookRepository;

    @MutationMapping
    public Book addBook(@Argument String title,
                        @Argument String author,
                        @Argument String isbn,
                        @Argument Integer publicationYear) {

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPublicationYear(publicationYear);

        return bookRepository.save(book);
    }

    @MutationMapping
    public Book updateBook(@Argument Long id,
                           @Argument String title,
                           @Argument String author,
                           @Argument String isbn,
                           @Argument Integer publicationYear) {

        Book book = bookRepository.findById(id).orElseThrow( ()-> new RuntimeException("Book not found") );
        if (title == null || author == null || isbn == null || publicationYear == null) {
            return null;
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPublicationYear(publicationYear);

        return bookRepository.save(book);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}
