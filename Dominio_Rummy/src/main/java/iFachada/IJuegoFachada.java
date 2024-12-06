/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package iFachada;

import entidades.Ficha;
import java.util.List;

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
    public boolean inicializarTablero();

    /**
     * Extrae una ficha del mazo de la partida.
     * 
     * @return la ficha extraída del mazo.
     */
    public Ficha extraerFicha();

    /**
     * Asigna una ficha al jugador actual.
     * 
     * @param ficha la ficha a asignar.
     * @return true si la ficha fue asignada correctamente, false en caso contrario.
     */
    public boolean darFichaJugadorActual(Ficha ficha);

    /**
     * Cambia el turno al siguiente jugador.
     */
    public void pasarTurno();

    /**
     * Asigna fichas al azar a los jugadores.
     * 
     * @return true si las fichas fueron asignadas correctamente, false en caso contrario.
     */
    public boolean asignarFichasAzar();

    /**
     * Asigna turnos a los jugadores de manera aleatoria.
     * 
     * @return true si los turnos fueron asignados correctamente, false en caso contrario.
     */
    public boolean asignarTurnos();

    /**
     * Agrega una combinación de fichas al juego.
     */
    public void agregarCombinacion();
 
    /**
     * Verifica si el mazo está vacío.
     * 
     * @return true si el mazo está vacío, false en caso contrario.
     */
    public boolean esMazoVacio();
    
    /**
     * Verifica si la cantidad de fichas en mano del jugador ha llegado a 0.
     * @return true si el jugador ya no cuenta con fichas.
     */
    public boolean verificarCantidadFichas();
    
    /**
     * Obtiene las fichas del jugador que coincida en nombre con el parámetro.
     * @param nombreJugador El nombre del jugador.
     * @return 
     */
    public List<Ficha> obtenerFichasJugador(String nombreJugador);
}
