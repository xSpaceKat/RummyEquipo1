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
public class Secuenciales extends Combinaciones{
    private Grupo grupo;

    public Secuenciales(List<Ficha> fichas, Jugador dueno) {
        super(fichas, dueno);
    }

    public Secuenciales(Grupo grupo, List<Ficha> fichas, Jugador dueno) {
        super(fichas, dueno);
        this.grupo = grupo;
    }

    public Secuenciales() {
    }

    public Secuenciales(Grupo grupo) {
        this.grupo = grupo;
    }
    
      
    
}
