package com.hibernate.introduction;

import com.hibernate.introduction.modelo.Persona;

import java.util.Date;
import java.util.List;

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
            // Persona persona = new Persona("Alejandra", "Hernandez",
            // "alejandra@gmail.com", fecha_nacimiento,
            // "http://fake-url");
            /*******
             * CRUD
             ******/

            // Create
            // session.persist(persona);
            // session.getTransaction().commit();

            // Read
            // Persona persona = session.find(Persona.class, 5);
            // Persona persona = session.byId(Persona.class).load(8);
            // System.out.println(persona);
            // List<Persona> personas = session.createQuery("from Persona",
            // Persona.class).list();
            // Iterar lista personas
            /*
             * for (int i = 0; i < personas.size(); i++) {
             * System.out.println(personas.get(i));
             * }
             */
            /*
             * List<Persona> personas2 = session
             * .createQuery("from Persona WHERE id > :id_persona and nombres LIKE '%:n'",
             * Persona.class)
             * .setParameter("id_persona", 5)
             * .setParameter("n", "Andres")
             * .list();
             */

            // Update
            Persona persona = session.find(Persona.class, 5);
            persona.setNombres("Andres");
            persona.setFoto("http://new-uri-photo");

            session.merge(persona);
            session.getTransaction().commit();

            // Delete

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Cerrar Sesión
        session.close();
    }
}
