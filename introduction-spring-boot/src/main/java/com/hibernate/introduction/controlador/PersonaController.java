package com.hibernate.introduction.controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.introduction.modelo.Persona;

@RestController
@RequestMapping("/personas")
public class PersonaController {

  // ATRIBUTOS
  private SessionFactory factory;

  public PersonaController() {
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Persona.class)
        .buildSessionFactory();
  }

  /*
   * @GetMapping
   * public String holaMundo() {
   * return "Hola mundo utilizando spring boot";
   * }
   */
  @GetMapping
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

  @GetMapping("/{id}")
  public Persona getPersona(@PathVariable(name = "id") int id) {
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

  @GetMapping("/commons")
  public List<Persona> getPersonasComun(@RequestParam String nombre, @RequestParam String apellido) {
    List<Persona> personas = new ArrayList<>();
    Session session = factory.openSession();
    session.beginTransaction();
    personas = session.createQuery("from Persona where nombres = :n and apellidos = :a",
        Persona.class)
        .setParameter("n", nombre)
        .setParameter("a", apellido)
        .list();

    return personas;
  }

  @PostMapping
  public String crearPersona(@RequestBody Persona persona) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      session.persist(persona);
      session.getTransaction().commit();
      message = "Persona creada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    session.close();
    return message;
  }

  @PutMapping
  public String updatePersona(@RequestBody Persona persona) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      session.merge(persona);
      session.getTransaction().commit();
      message = "Persona actualizada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    session.close();
    return message;
  }

  @DeleteMapping("/{id}")
  public String deletePersona(@PathVariable(name = "id") int id) {
    String message = "";
    Session session = factory.openSession();
    session.beginTransaction();
    try {
      Persona persona = getPersona(id);
      session.remove(persona);
      session.getTransaction().commit();
      session.close();
      message = "Persona eliminada con éxito";
    } catch (Exception e) {
      message = e.getMessage();
    }
    return message;
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
