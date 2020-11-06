package com.antra.user.graphqldemo;

import com.antra.user.graphqldemo.entity.Author;
import com.antra.user.graphqldemo.entity.Book;
import com.antra.user.graphqldemo.repository.AuthorRepository;
import com.antra.user.graphqldemo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.RemoteException;

@SpringBootApplication
public class GraphqldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphqldemoApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(BookRepository bookRepository, AuthorRepository authorRepository) throws RemoteException {

        return args -> {
            authorRepository.deleteAll();
            Author a1 = Author.builder().id("1").firstName("Tim").lastName("Mar").build();
            a1 = authorRepository.save(a1);
            Author a2 = Author.builder().id("2").firstName("Jerry").lastName("Jo").build();
            a2 = authorRepository.save(a2);
            bookRepository.deleteAll();
            bookRepository.save(Book.builder().id("book-1").name("Hello World").pageCount(120).author(a1).build());
            bookRepository.save(Book.builder().id("book-2").name("Hello World again").pageCount(220).author(a2).build());
            bookRepository.save(Book.builder().id("book-3").name("Never say never").pageCount(50).author(a2).build());

        };
    }
}
