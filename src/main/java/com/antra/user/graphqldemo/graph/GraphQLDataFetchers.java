package com.antra.user.graphqldemo.graph;

import com.antra.user.graphqldemo.entity.Author;
import com.antra.user.graphqldemo.entity.Book;
import com.antra.user.graphqldemo.repository.AuthorRepository;
import com.antra.user.graphqldemo.service.BookService;
import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class GraphQLDataFetchers {

    private BookService bookService;
    private AuthorRepository authorRepository;

    public GraphQLDataFetchers(BookService bookService, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return bookService.getBookById(bookId);
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            String authorId = dataFetchingEnvironment.getArgument("id");
            return authorRepository.findById(authorId);
        };
    }

    public DataFetcher getAllBooksDataFetcher() {
        return dataFetchingEnvironment -> {
            return bookService.getAllBooks();
        };
    }

    public DataFetcher getAllAuthorsDataFetcher() {
        return dataFetchingEnvironment -> {
            return authorRepository.findAll();
        };
    }

    public DataFetcher createAuthor() {
        return dataFetchingEnvironment -> {
            String authorFn = dataFetchingEnvironment.getArgument("firstName");
            String authorLn = dataFetchingEnvironment.getArgument("lastName");
            return authorRepository.save(Author.builder().id(UUID.randomUUID().toString()).firstName(authorFn).lastName(authorLn).build());
        };
    }
}
