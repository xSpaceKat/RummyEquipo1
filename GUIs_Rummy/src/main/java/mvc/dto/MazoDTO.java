/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.dto;

import entidades.Jugador;

/**
 *
 * @author galan
 */
public class MazoDTO {
    private int fichas, comodines;
    private Jugador jugador;

    public MazoDTO(int fichas, int comodines, Jugador jugador) {
        this.fichas = fichas;
        this.comodines = comodines;
        this.jugador= jugador;
    }

    public int getFichas() {
        return fichas;
    }

    public void setFichas(int fichas) {
        this.fichas = fichas;
    }

    public int getComodines() {
        return comodines;
    }

    public void setComodines(int comodines) {
        this.comodines = comodines;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
}
