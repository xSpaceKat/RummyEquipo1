/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;

/**
 *
 * @author galan
 */
public class Grupo {
    private List<Ficha> fichas;
    private Jugador dueno;

    // Constructor
    public Grupo(List<Ficha> fichas, Jugador dueno) {
        this.fichas = fichas;
        this.dueno = dueno;
    }

    // Getters y Setters
    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public Jugador getDueno() {
        return dueno;
    }

    public void setDueno(Jugador dueno) {
        this.dueno = dueno;
    }
}
