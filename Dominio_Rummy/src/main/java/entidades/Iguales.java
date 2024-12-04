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
public class Iguales extends Combinaciones{
    private int numero;

    public Iguales(List<Ficha> fichas, Jugador dueno) {
        super(fichas, dueno);
    }

    public Iguales(int numero, List<Ficha> fichas, Jugador dueno) {
        super(fichas, dueno);
        this.numero = numero;
    }

    public Iguales() {
    }

    public Iguales(int numero) {
        this.numero = numero;
    }
    
      
    
}
