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
public class Combinaciones implements Serializable{
    private List<Ficha> fichas;
    private Jugador dueno;

    // Constructor
    public Combinaciones(List<Ficha> fichas, Jugador dueno) {
        this.fichas = fichas;
        this.dueno = dueno;
    }

    public Combinaciones() {
        fichas= new ArrayList<>();
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
