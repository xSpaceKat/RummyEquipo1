package mvc.controladores;

import java.awt.Color;
import mvc.modelos.ModeloPerfil;

/**
 * Controlador del MVC. Se encuentra dentro de la vista y es llamado por esta para controlar a la lógica.
 * El controlador contiene un modelo, el cual es la logica de nuestro programa, y se encarga de llamar a este modelo para que realice las acciones necesarias sobre el programa.
 * @author galan
 */
public class ControladorPerfil {
    
    ModeloPerfil m; //Nuestra lógica del programa
    
    /**
     * Constructora del controlador. Creará un controlador, y se le asignará el modelo correspondiente.
     * @param m 
     */
    public ControladorPerfil(ModeloPerfil m){
        this.m = m;
    }

    public void mostrarUnirsePartida() {
        m.mostrarUnirsePartida();
    }
    
    public void agregarColores(Color ccolor1, Color ccolor2, Color ccolor3, Color ccolor4){
        m.agregarColores(ccolor1, ccolor2, ccolor3, ccolor4);
    }

    /**
     * 
     */
    
    
}
