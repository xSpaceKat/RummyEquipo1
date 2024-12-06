package iFachada;

import entidades.Combinaciones;
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
    Combinaciones agregarCombinacion(List<Ficha> fichas);

    /**
     * Verifica si el mazo está vacío.
     * 
     * @return true si el mazo está vacío, false en caso contrario.
     */
    boolean esMazoVacio();
    
    /**
     * Verifica que la combinacion sea adecuada
     * 
     * @return true si la combinacion es valida, false en caso contrario.
     */
     boolean validaCombinacion();
    
    /**
     * Metodo que separa las fichas en dos grupos/combinaciones.
     * 
     * @return 2do grupo de combinaciones
     */
    Combinaciones separarGrupo();
    
    /**
     * Metodo que sustituye una ficha para mover otra de la combinacion
     * 
     * @return La combinacion modificada
     */
    Combinaciones Sustituir();
    
    /**
     * Metodo que mueve un ficha de la combinaciones
     * 
     * @return La combinacion cambiada
     */
    Combinaciones mover();
    
    /**
     * Verifica que los extremos de una combinacion se hayan agregado correctamente
     * 
     * @return True si son extremos, false en caso contrario
     */
    boolean verificarExtremos();
    
    /**
     * 
     * 
     * @return 
     */
    Combinaciones arrastrarExtremo();
    
    /**
     * 
     * 
     * @return 
     */
    Combinaciones cambiarFichaExtremo();
}
