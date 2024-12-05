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
public class Turno implements Serializable{
    List<Jugador> jugadores;
    int turnoActual;

    public Turno() {
        turnoActual=0;
        jugadores= new ArrayList<>();
    }

    public Turno(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        turnoActual=0;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    public void setTurnoActual(int turnoActual) {
        this.turnoActual = turnoActual;
    }
    
    public void siguiente(){
        turnoActual = (turnoActual % jugadores.size()) + 1; // Incrementa y reinicia cuando alcanza el tamaño
    }
    
}
