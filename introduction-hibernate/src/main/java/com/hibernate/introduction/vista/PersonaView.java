package com.hibernate.introduction.vista;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.hibernate.introduction.controlador.PersonaController;

public class PersonaView {
  // ATRIBUTO
  private PersonaController controller;

  // CONSTRUCTOR
  public PersonaView(PersonaController controller) {
    this.controller = controller;
  }

  public void crearPersona() {
    // Solicitar datos
    String nombres = JOptionPane.showInputDialog(null, "Por favor ingrese su nombre: ");
    String apellidos = JOptionPane.showInputDialog(null, "Por favor ingrese su apellido completo: ");
    String email = JOptionPane.showInputDialog(null, "Ingrese su email: ");
    String fecha = JOptionPane.showInputDialog(null, "Fecha nacimiento (dd/mm/aaaa)");
    String foto = JOptionPane.showInputDialog(null, "Url foto de perfil:");

    String arrayFecha[] = fecha.split("/");
    int year = Integer.parseInt(arrayFecha[2]);
    int month = Integer.parseInt(arrayFecha[1]) - 1;
    int date = Integer.parseInt(arrayFecha[0]);
    Calendar fecha_nacimiento = Calendar.getInstance();
    fecha_nacimiento.set(year, month, date);
    System.out.println(fecha_nacimiento);

    boolean create = controller.crearPersona(nombres, apellidos, email, fecha_nacimiento, foto);

    if (create) {
      JOptionPane.showMessageDialog(null, "Usuario creado con éxito");
    } else {
      JOptionPane.showMessageDialog(null, "Por favor intenta mas tarde");
    }

  }

  public void mostrarPersonas() {
    List personas = controller.obtenerPersonas();
    String info = "--------------PERSONAS--------------\n";
    for (int i = 0; i < personas.size(); i++) {
      info += personas.get(i);
    }
    JOptionPane.showMessageDialog(null, info);
  }

}
