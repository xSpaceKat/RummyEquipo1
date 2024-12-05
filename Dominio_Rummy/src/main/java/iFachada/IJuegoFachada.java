/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iFachada;

import entidades.Ficha;

/**
 *
 * @author galan
 */
public interface IJuegoFachada {

    /**
     * Inicializa el tablero de la partida.
     * 
     * @return true si el tablero fue inicializado correctamente, false en caso contrario.
     */
    boolean inicializarTablero();

    /**
     * Extrae una ficha del mazo de la partida.
     * 
     * @return la ficha extraída del mazo.
     */
    Ficha extraerFicha();

    /**
     * Asigna una ficha al jugador actual.
     * 
     * @param ficha la ficha a asignar.
     * @return true si la ficha fue asignada correctamente, false en caso contrario.
     */
    boolean darFichaJugadorActual(Ficha ficha);

    /**
     * Cambia el turno al siguiente jugador.
     */
    void pasarTurno();

    /**
     * Asigna fichas al azar a los jugadores.
     * 
     * @return true si las fichas fueron asignadas correctamente, false en caso contrario.
     */
    boolean asignarFichasAzar();

    /**
     * Asigna turnos a los jugadores de manera aleatoria.
     * 
     * @return true si los turnos fueron asignados correctamente, false en caso contrario.
     */
    boolean asignarTurnos();

    /**
     * Agrega una combinación de fichas al juego.
     */
    void agregarCombinacion();

    /**
     * Verifica si el mazo está vacío.
     * 
     * @return true si el mazo está vacío, false en caso contrario.
     */
    boolean esMazoVacio();
}
