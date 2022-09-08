package com.hibernate.introduction;

import com.hibernate.introduction.controlador.PersonaController;
import com.hibernate.introduction.vista.PersonaView;

public class App {
    public static void main(String[] args) {
        PersonaController controller = new PersonaController();
        PersonaView view = new PersonaView(controller);
        view.menu();
    }
}
