package com.example.springbootrestdatajpa.controllers;

import com.example.springbootrestdatajpa.entities.Book;
import com.example.springbootrestdatajpa.repositories.BookRepository;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    //Buscar todos los libros de bbdd
    @GetMapping("/books")
    public List<Book> findAll() {
        //Recuperar y devolver los libros de bbdd
        return bookRepository.findAll();
    }

    //Buscar libro por id
//    @GetMapping("/books/{id}")
//    public Book findById(@PathVariable Long id) {
//
//        Optional<Book> book = bookRepository.findById(id);
//
//        return book.orElse(null);
//    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {

        Optional<Book> book = bookRepository.findById(id);

        // Return con programacion funcional
//        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

        return book.isPresent() ? ResponseEntity.ok(book.get()) : ResponseEntity.notFound().build();
}

    // Crear un nuevo libro en bbdd

    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {

        return bookRepository.save(book);

    }


    // Actualizar un libro existente en bbdd
    @PatchMapping("/modify/{id}")
    public Book modifyBook(@PathVariable Long id,
                           @RequestParam(required = false) String title,
                           @RequestParam(required = false) String author,
                           @RequestParam(required = false) Integer pages,
                           @RequestParam(required = false) Double price,
                           @RequestParam(required = false) LocalDate release,
                           @RequestParam(required = false) boolean online) {
        Optional<Book> book = bookRepository.findById(id);
        Book bookModified = null;
        if (book.isPresent()) {
            bookModified = book.get();
        }
        if (Objects.nonNull(author))
            bookModified.setAuthor(author);
        if (Objects.nonNull(title))
            bookModified.setTitle(title);
        if (Objects.nonNull(pages))
            bookModified.setPages(pages);
        if (Objects.nonNull(price))
            bookModified.setPrice(price);
        if (Objects.nonNull(release))
            bookModified.setRelease(release);
        if (online)
            bookModified.setOnline(online);

        return bookModified;
    }

    //Borrar un libro de bbdd

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable Long id) {

        bookRepository.deleteById(id);
    }
}
