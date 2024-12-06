/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import entidades.Jugador;
import entidades.Partida;
import iFachada.ILobbyFachada;

/**
 *
 * @author galan
 */
public class LobbyFachada implements ILobbyFachada{
    private Partida partida;

    // Constructor que recibe la partida
    public LobbyFachada(Partida partida) {
        this.partida = partida;
    }

    // Validar si la sala está llena
    public boolean validarSalaLlena() {
        if (partida.getJugadores().size() >= 4) {
            System.out.println("La sala está llena.");
            return true;
        } else {
            System.out.println("La sala tiene espacio.");
            return false;
        }
    }

    // Validar si el juego ha iniciado
    public boolean validarJuegoIniciado() {
        if (partida.isEstado()) {
            System.out.println("El juego ya ha comenzado.");
            return true;
        } else {
            System.out.println("El juego no ha comenzado.");
            return false;
        }
    }

    // Verificar si el estado de los jugadores es válido
    public boolean verificarEstados() {
        return partida.verificarEstados();
    }
    
    // Verificar si el estado de los jugadores es válido
    public boolean cambiarEstado() {
        
        return false;
        
    }

    // Unir un jugador a la partida
    public void unirJugador(Jugador jugador) {
        partida.unirJugador(jugador);
        System.out.println("Jugador " + jugador.getNombre() + " ha sido unido al juego.");
    }

    @Override
    public boolean estaListo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
