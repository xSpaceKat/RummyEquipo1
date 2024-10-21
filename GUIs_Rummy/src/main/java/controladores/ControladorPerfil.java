/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.ModeloPerfil;

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

    /**
     * 
     */
    
    
}
