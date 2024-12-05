/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author galan
 */
public class Partida implements Serializable{
    private static Partida instancia;
    
    private List<Jugador> jugadores;
    private boolean estado;
    private String codigo;
    private Mazo mazo;
    private Turno turnos;
    private Tablero tablero;

    // Método para obtener la instancia única de la clase
    public static Partida obtenerInstancia() {
        if (instancia == null) {
            instancia = new Partida();
        }
        return instancia;
    }

    // Método para actualizar la instancia actual de la partida
    public static void actualizarInstancia(Partida nuevaPartida) {
        instancia = nuevaPartida;
    }

    public Partida() {
        jugadores= new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
    }
    
    public void unirJugador(Jugador jugador){
        jugadores.add(jugador);
    }

    public Turno getTurnos() {
        return turnos;
    }

    public void setTurnos(Turno turnos) {
        this.turnos = turnos;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    
    
    
    //Verifica si es que todos los jugadores estan listos para empezar la partida
    public boolean verificarEstados(){
        for (Jugador jugador : jugadores) {
            if (!jugador.getEstado()) {
                return false;
            }
        }
        return true;
    }

    public boolean cambiarEstado(String nombreJugador, boolean nuevoEstado) {
        for (Jugador jugador : this.jugadores) {
            if (jugador.getNombre().equals(nombreJugador)) {
                jugador.setEstado(nuevoEstado);
                System.out.println("Estado del jugador " + nombreJugador + " cambiado a " + nuevoEstado);
            }
        }
        return false;
    }

}
