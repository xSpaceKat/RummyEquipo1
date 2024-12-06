/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author galan
 */
public class Ficha implements Serializable{

    public Ficha() {
    }
    
    public String getTipoFicha() {
        if (this instanceof FichaNormal) {
            return "FichaNormal";
        } else if (this instanceof Comodin) {
            return "Comodin";
        } else {
            return "";
        }
    }
    
}
