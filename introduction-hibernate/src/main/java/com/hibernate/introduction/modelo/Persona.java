package com.hibernate.introduction.modelo;

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
  @Column(name = "id")
  private int id;
  @Column(name = "nombres")
  private String nombres;
  @Column(name = "apellidos")
  private String apellidos;
  @Column(name = "email")
  private String email;
  @Column(name = "fecha_nacimiento")
  private Date fecha_nacimiento;
  @Column(name = "foto")
  private String foto;

  // CONSTRUCTOR
  public Persona(int id, String nombres, String apellidos, String email, Date fecha_nacimiento, String foto) {
    this.id = id;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.email = email;
    this.fecha_nacimiento = fecha_nacimiento;
    this.foto = foto;
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

  public Date getFecha_nacimiento() {
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

  public void setFecha_nacimiento(Date fecha_nacimiento) {
    this.fecha_nacimiento = fecha_nacimiento;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

}
