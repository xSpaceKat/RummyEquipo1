/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.controladores;

import mvc.modelos.ModeloCrearPartida;

/**
 * Controlador del MVC. Se encuentra dentro de la vista y es llamado por esta para controlar a la lógica.
 * El controlador contiene un modelo, el cual es la logica de nuestro programa, y se encarga de llamar a este modelo para que realice las acciones necesarias sobre el programa.
 * @author galan
 */
public class ControladorCrearPartida {
    ModeloCrearPartida m; //Nuestra lógica del programa
    
    /**
     * Constructora del controlador. Creará un controlador, y se le asignará el modelo correspondiente.
     * @param m 
     */
    public ControladorCrearPartida(ModeloCrearPartida m){
        this.m = m;
    }

    /**
     * 
     */
    public void mostrarMenu() {
        m.mostrarMenu();
    }
    
    public void mostrarLobbyPartida() {
        m.mostrarLobbyPartida();
    }
    
    /**
     * Función sumar. Notifica al modelo que quiere incrementar el valor del rango de fichas.
     */
    public void sumarRangoFichas(){
        m.sumarRangoFichas();
    }
    
    /**
     * Función sumar. Notifica al modelo que quiere incrementar el valor de los comodines.
     */
    public void sumarComodines(){
        m.sumarComodines();
    }
    
    /**
     * Función restar. Notifica al modelo que quiere decrementar el valor del rango de fichas.
     */
    public void restarRangoFichas(){
        m.restarRangoFichas();
    }
    
    /**
     * Función restar. Notifica al modelo que quiere decrementar el valor de los comodines.
     */
    public void restarComodines(){
        m.restarComodines();
    }

    
    
}
