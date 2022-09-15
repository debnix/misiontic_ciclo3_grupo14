package com.hibernate.introduction.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.hibernate.introduction.servicios.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

  private PersonaService service;

  public PersonaController() {
    service = new PersonaService();
  }

  @GetMapping
  public List<Persona> obtenerPersonas() {
    return service.obtenerPersonas();
  }

  @GetMapping("/{id}")
  public Persona getPersona(@PathVariable(name = "id") int id) {
    return service.getPersona(id);
  }

  @GetMapping("/commons")
  public List<Persona> getPersonasComun(@RequestParam String nombre, @RequestParam String apellido) {
    return service.getPersonasComun(nombre, apellido);
  }

  @PostMapping
  public String crearPersona(@RequestBody Persona persona) {
    return service.crearPersona(persona);
  }

  @PutMapping
  @CrossOrigin("*")
  public String updatePersona(@RequestBody Persona persona) {
    return service.updatePersona(persona);
  }

  @DeleteMapping("/{id}")
  @CrossOrigin("*")
  public String deletePersona(@PathVariable(name = "id") int id) {
    return service.deletePersona(id);
  }

}
