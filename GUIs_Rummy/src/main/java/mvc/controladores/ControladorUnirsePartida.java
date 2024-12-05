package mvc.controladores;

import mvc.modelos.ModeloUnirsePartida;

/**
 * Controlador del MVC. Se encuentra dentro de la vista y es llamado por esta
 * para controlar a la lógica. El controlador contiene un modelo, el cual es la
 * logica de nuestro programa, y se encarga de llamar a este modelo para que
 * realice las acciones necesarias sobre el programa.
 *
 * @author galan
 */
public class ControladorUnirsePartida {

    ModeloUnirsePartida m; //Nuestra lógica del programa

    /**
     * Constructora del controlador. Creará un controlador, y se le asignará el
     * modelo correspondiente.
     *
     * @param m
     */
    public ControladorUnirsePartida(ModeloUnirsePartida m) {
        this.m = m;
    }

    /**
     *
     */
    public void mostrarMenu() {
        m.mostrarMenu();
    }

    public void mostrarPerfil() {
        m.mostrarPerfil();
    }

}
