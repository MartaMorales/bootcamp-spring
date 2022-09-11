package com.example.springbootrestdatajpa.repositories;

import com.example.springbootrestdatajpa.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
