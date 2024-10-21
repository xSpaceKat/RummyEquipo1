/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author galan
 */
public class FichaNormal extends Ficha{
    private int numero;
    private Color color;

    // Constructor
    public FichaNormal(int puntos, int numero, Color color) {
        super(puntos);
        this.numero = numero;
        this.color = color;
    }

    public FichaNormal(int numero, Color color, int puntos) {
        super(puntos);
        this.numero = numero;
        this.color = color;
    }
    
    
}
