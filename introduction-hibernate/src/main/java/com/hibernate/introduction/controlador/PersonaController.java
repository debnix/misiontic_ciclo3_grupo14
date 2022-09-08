package com.hibernate.introduction.controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

  public boolean crearPersona(String nombres, String apellidos, String email, Calendar fecha_nacimiento, String foto) {
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

  public List<Persona> obtenerPersonas() {
    List<Persona> personas = new ArrayList<Persona>();
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      personas = session.createQuery("from Persona", Persona.class).list();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return personas;
  }

}
