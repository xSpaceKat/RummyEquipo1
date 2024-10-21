/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.ModeloLobbyPartida;

/**
 *
 * @author OMEN
 */
public class ControladorLobbyPartida {
    ModeloLobbyPartida m; //Nuestra lógica del programa
    
    /**
     * Constructora del controlador. Creará un controlador, y se le asignará el modelo correspondiente.
     * @param m 
     */
    public ControladorLobbyPartida(ModeloLobbyPartida m){
        this.m = m;
    }

    /**
     * 
     */
    
    public void mostrarPerfil() {
        m.mostrarPerfil();
    }
    
    public void mostrarCrearPartida() {
        m.mostrarCrearPartida();
    }
}
