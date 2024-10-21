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
class Mazo {
    private List<Ficha> mazo;
    private int rangos;
    private int cantidadComodines;

    // Constructor
    public Mazo(List<Ficha> mazo, int rangos, int cantidadComodines) {
        this.mazo = mazo;
        this.rangos = rangos;
        this.cantidadComodines = cantidadComodines;
    }

    public List<Ficha> getMazo() {
        return mazo;
    }

    public void setMazo(List<Ficha> mazo) {
        this.mazo = mazo;
    }

    public int getRangos() {
        return rangos;
    }

    public void setRangos(int rangos) {
        this.rangos = rangos;
    }

    public int getCantidadComodines() {
        return cantidadComodines;
    }

    public void setCantidadComodines(int cantidadComodines) {
        this.cantidadComodines = cantidadComodines;
    }
    
    
}
