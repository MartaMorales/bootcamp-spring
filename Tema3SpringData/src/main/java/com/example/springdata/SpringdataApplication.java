package com.example.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringdataApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringdataApplication.class, args);
        CocheRepository cocheRepository = context.getBean(CocheRepository.class);

        // Crear y almacenar un coche en bbdd
        Coche toyota = new Coche(null, 2010, "prius", "toyota");
        cocheRepository.save(toyota);

        System.out.println("El numero de coches en bbdd es: " + cocheRepository.count());

        //Recuperar el coche de bbdd
        System.out.println(cocheRepository.findAll());


    }

}
