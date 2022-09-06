package com.hibernate.introduction;

import com.hibernate.introduction.modelo.Persona;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Crear objeto para el manejo de la sesión de la BD
        SessionFactory secionFactory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Persona.class)
                .buildSessionFactory();
        System.out.println("Hola mundo");
    }
}
