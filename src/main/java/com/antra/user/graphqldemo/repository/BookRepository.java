package com.antra.user.graphqldemo.repository;

import com.antra.user.graphqldemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
