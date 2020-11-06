package com.antra.user.graphqldemo.repository;

import com.antra.user.graphqldemo.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {

}
