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

  public Persona getPersona(int id) {
    Persona persona = new Persona();
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      persona = session.find(Persona.class, id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    session.close();
    return persona;
  }

  public boolean updatePersona(int id, String nombres, String apellidos, String email, Calendar fecha, String foto) {
    boolean update = false;
    Persona persona = getPersona(id);
    persona.setNombres(nombres);
    persona.setApellidos(apellidos);
    persona.setEmail(email);
    persona.setFecha_nacimiento(fecha);
    persona.setFoto(foto);

    Session session = factory.openSession();
    session.beginTransaction();
    try {
      session.merge(persona);
      session.getTransaction().commit();
      update = true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    session.close();
    return update;
  }

  public Calendar stringToCalendar(String fecha) {
    String arrayFecha[] = fecha.split("/");
    int year = Integer.parseInt(arrayFecha[2]);
    int month = Integer.parseInt(arrayFecha[1]) - 1;
    int date = Integer.parseInt(arrayFecha[0]);
    Calendar fecha_nacimiento = Calendar.getInstance();
    fecha_nacimiento.set(year, month, date);
    return fecha_nacimiento;
  }

}
