package com.example.springbootrestdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringbootRestDatajpaApplication {

    public static void main(String[] args) {
        /*ApplicationContext context =*/
        SpringApplication.run(SpringbootRestDatajpaApplication.class, args);
//        BookRepository repository = context.getBean(BookRepository.class);
//
//        //CRUD
//        //Crear libro
//
//        Book book1 = new Book(null, "Juego de tronos", "J.R.R. Martin", 400, 19.90, LocalDate.of(1989, 6, 25), true);
//        Book book2 = new Book(null, "El señor de los anillos", "Tolkien", 1000, 50.90, LocalDate.of(1920, 3, 12), false);
//
//
//        //Almacenar libro
//        System.out.println("Num libros en bbdd: " + repository.findAll().size());
//
//        repository.save(book1);
//        repository.save(book2);
//
//        //Recuperar todos los libros
//        System.out.println("Num libros en bbdd: " + repository.findAll().size());
//
//        //Borrar un libro
//        repository.deleteById(1L);
//        System.out.println("Num libros en bbdd: " + repository.findAll().size());



    }

}
