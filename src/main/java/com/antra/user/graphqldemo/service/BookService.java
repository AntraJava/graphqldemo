package com.antra.user.graphqldemo.service;

import com.antra.user.graphqldemo.entity.Book;

import java.util.List;

public interface BookService {
    Book getBookById(String bookId);

    List<Book> getAllBooks();
}
