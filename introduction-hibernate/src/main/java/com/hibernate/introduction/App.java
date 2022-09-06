package com.hibernate.introduction;

import com.hibernate.introduction.modelo.Persona;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Crear objeto para el manejo de la sesión de la BD
        SessionFactory sessionFactory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Persona.class)
                .buildSessionFactory();
        System.out.println("Hola mundo");

        // Abrir Sesión
        Session session = sessionFactory.openSession();

        // ...Generar transacciones
        try {
            // Crear fecha
            Date fecha_nacimiento = new Date();
            // Crear Objeto
            Persona persona = new Persona(1, "Andres", "Quintero", "andres@gmail.com", fecha_nacimiento,
                    "http://fake-url");
            // Preparar sesión para generar transacciones
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar Sesión
        session.close();
    }
}
