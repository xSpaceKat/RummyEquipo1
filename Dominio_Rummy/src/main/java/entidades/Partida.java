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
    private List<Jugador> jugadores;
    private boolean estado;
    private String codigo;
    private Mazo mazo;

    // Constructor
    public Partida(List<Jugador> jugadores, boolean estado, String codigo, Mazo mazo) {
        this.jugadores = jugadores;
        this.estado = estado;
        this.codigo = codigo;
        this.mazo = mazo;
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
    
}
