package app;

import controller.ControladorInformes;
import view.Interfaz;

/**
 *
 * @author JancarlosCh
 */
public class App {
    public static void main(String[] args) {
        Interfaz vista = new Interfaz();
        ControladorInformes controlador = new ControladorInformes(vista);
    }
}
