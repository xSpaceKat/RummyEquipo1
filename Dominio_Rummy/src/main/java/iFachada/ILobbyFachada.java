/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iFachada;

import entidades.Jugador;
import entidades.Partida;

/**
 *
 * @author galan
 */
public interface ILobbyFachada {
    /**
     * Verifica si el mazo está vacío.
     * 
     * @return true si el mazo está vacío, false en caso contrario.
     */
    boolean estaListo();

    // Validar si la sala está llena
    public boolean validarSalaLlena();
    
    // Validar si el juego ha iniciado
    public boolean validarJuegoIniciado();
    

    // Verificar si el estado de los jugadores es válido
    public boolean verificarEstados();
    
    // Verificar si el estado de los jugadores es válido
    public boolean cambiarEstado();

    // Unir un jugador a la partida
    public void unirJugador(Jugador jugador);
    

}
