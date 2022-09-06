package com.hibernate.introduction.modelo;

import java.util.Date;

public class Persona {
  // ATRIBUTOS
  private int id;
  private String nombres;
  private String apellidos;
  private String email;
  private Date fecha_nacimiento;
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
