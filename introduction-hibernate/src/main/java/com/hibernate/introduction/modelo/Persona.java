package com.hibernate.introduction.modelo;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indicar que la Clase representa una entidad en BD
@Entity
// Nombre de la tabla/entidad a la que representa la Clase
@Table(name = "users")
public class Persona {
  // ATRIBUTOS - CAMPOS EN BD
  @Id
  private int id;
  private String nombres;
  private String apellidos;
  private String email;
  private Calendar fecha_nacimiento;
  private String foto;

  public Persona() {
  }

  // CONSTRUCTOR
  public Persona(String nombres, String apellidos, String email, Calendar fecha_nacimiento, String foto) {
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.email = email;
    this.fecha_nacimiento = fecha_nacimiento;
    this.foto = foto;
  }

  @Override
  public String toString() {
    String info = "------------------------------\n";
    info += "Id: " + id;
    info += "\nNombres: " + nombres;
    info += "\nApellidos: " + apellidos;
    info += "\nEmail: " + email;
    info += "\nFecha nacimiento: " + fecha_nacimiento.getTime();
    info += "\nFoto: " + foto;
    info += "\n------------------------------\n";

    return info;
  }

  // CONSULTORES
  public int getId() {
    return id;
  }

  public String getNombres() {
    return nombres;
  }

  public String getApellidos() {
    return apellidos;
  }

  public String getEmail() {
    return email;
  }

  public Calendar getFecha_nacimiento() {
    return fecha_nacimiento;
  }

  public String getFoto() {
    return foto;
  }

  // MODIFICADORES
  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFecha_nacimiento(Calendar fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

}
