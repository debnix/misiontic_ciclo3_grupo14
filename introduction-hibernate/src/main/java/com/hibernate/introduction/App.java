package com.hibernate.introduction;

import com.hibernate.introduction.modelo.Persona;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Crear objeto para el manejo de la sesión de la BD
        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Persona.class)
                .buildSessionFactory();

        // Abrir Sesión
        Session session = factory.openSession();
        // Preparar sesión para generar transacciones
        session.beginTransaction();
        // ...Generar transacciones
        try {
            // Crear fecha
            Date fecha_nacimiento = new Date();
            // Crear Objeto
            Persona persona = new Persona("Dario", "Quintero", "andres@gmail.com", fecha_nacimiento, "http://fake-url");

            session.persist(persona);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar Sesión
        session.close();
    }
}
