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

    Calendar fecha_nacimiento = controller.stringToCalendar(fecha);
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

  public void actualizarPersona() {
    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor ingrese la cédula"));
    String nombres = JOptionPane.showInputDialog(null, "Por favor ingrese el nuevo nombre");
    String apellidos = JOptionPane.showInputDialog(null, "Por favor ingrese el nuevo apellido");
    String email = JOptionPane.showInputDialog(null, "Por favor ingrese el nuevo Email");
    String fecha = JOptionPane.showInputDialog(null, "Ingrese la nueva fecha de nacimiento (dd/mm/aaaa): ");
    String foto = JOptionPane.showInputDialog(null, "Por favor ingrese la nueva foto de perfil");

    Calendar fecha_nacimiento = controller.stringToCalendar(fecha);
    boolean update = controller.updatePersona(id, nombres, apellidos, email, fecha_nacimiento, foto);
    if (update) {
      JOptionPane.showMessageDialog(null, "Información actualizada con éxito");
    } else {
      JOptionPane.showMessageDialog(null, "Por favor intenta mas tarde");
    }
  }

  public void menu() {
    String message = "---------------CRUD PERSONAS-----------\n";
    message += "1) Crear persona\n";
    message += "2) Listar personas\n";
    message += "3) Actualizar persona\n";
    message += "-1) Salir\n";

    int opc = 0;

    while (opc != -1) {
      opc = Integer.parseInt(JOptionPane.showInputDialog(null, message));
      // Evaluar la opción ingresada
      switch (opc) {
        case 1:
          crearPersona();
          break;
        case 2:
          mostrarPersonas();
          break;
        case 3:
          actualizarPersona();
          break;
        case -1:
          break;
        default:
          JOptionPane.showMessageDialog(null, "Por favor ingrese una opción válida");
          break;
      }
    }
  }

}
