package com.example.springbootrestdatajpa.controllers;

import com.example.springbootrestdatajpa.entities.Book;
import com.example.springbootrestdatajpa.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookRepository bookRepository;

    //Buscar todos los libros de bbdd
    @GetMapping("/books")
    public List<Book> findAll() {
        //Recuperar y devolver los libros de bbdd
        log.info("Ejecutando metodo buscar todo");
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
        log.info("Ejecutando metodo buscar por id");
        Optional<Book> book = bookRepository.findById(id);

        // Return con programacion funcional
//        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

        return book.isPresent() ? ResponseEntity.ok(book.get()) : ResponseEntity.notFound().build();
    }

    // Crear un nuevo libro en bbdd

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        // En el body de postman no incluir en id, ya que se gestiona solo
        // Por si acaso hacemos un control de id
        log.info("Ejecutando metodo crear");
        if (Objects.nonNull(book.getId())) { // quiere decir que existe el id y por tanto no es una creacion
            log.warn("Intentando crear un libro con id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }


    // Actualizar un libro existente en bbdd
    @PutMapping("/books/")
    public ResponseEntity<Book> update(@RequestBody Book book) {
        log.info("Ejecutando metodo modificar");
        if (Objects.isNull(book.getId())) { // Si no tiene id quiere decir que si es una creacion
            log.warn("Intentando actualizar un libro que no existe");
            return ResponseEntity.badRequest().build();
        }
        if (bookRepository.existsById(book.getId())) {
            log.warn("Intentando actualizar un libro que existe");
            return ResponseEntity.ok(bookRepository.save(book));

        }
        log.warn("Intentando actualizar un libro que no existe");
        return ResponseEntity.notFound().build();
    }

    //Borrar un libro de bbdd

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        log.info("Ejecutando metodo borrar por id");
        if (Objects.nonNull(bookRepository.existsById(id))) {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        log.warn("Intentando borrar un libro que no existe");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/books")
    public ResponseEntity<Book> deleteall() {
        log.info("Ejecutando metodo borrar todo");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
