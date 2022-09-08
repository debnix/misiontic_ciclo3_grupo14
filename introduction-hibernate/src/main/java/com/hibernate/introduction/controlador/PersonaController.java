package com.hibernate.introduction.controlador;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.modelo.Persona;

public class PersonaController {

  // ATRIBUTOS
  private SessionFactory factory;

  public PersonaController() {
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Persona.class)
        .buildSessionFactory();
  }

  public boolean crearPersona(String nombres, String apellidos, String email, Date fecha_nacimiento, String foto) {
    boolean create = false;
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      Persona persona = new Persona(nombres, apellidos, email, fecha_nacimiento, foto);
      session.persist(persona);
      session.getTransaction().commit();
      create = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    session.close();
    return create;
  }

}
