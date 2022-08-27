package com.springbootcamp;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    public NotificationService() {
    }

    public String imprimirSaludo(){
        return "Hola";
    }
}
