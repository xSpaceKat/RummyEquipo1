/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 *
 * @author galan
 */
class Mazo implements Serializable{
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
    
    public Ficha sacarFicha(){
        if (esMazoVacio()) {
            throw new IllegalArgumentException("La lista está vacía");
        }

        // Crear un generador de números aleatorios
        Random random = new Random();

        // Generar un índice al azar dentro del rango de la lista
        int randomIndex = random.nextInt(mazo.size());

        // Obtener el número en ese índice
        Ficha fichaObtenida = mazo.get(randomIndex);

        // Eliminar el número de la lista
        mazo.remove(randomIndex);

        // Devolver el número eliminado
        return fichaObtenida;
    }
    
    public void agregarFicha(Ficha ficha){
        mazo.add(ficha);
    }
    
    public boolean esMazoVacio(){
        return mazo.isEmpty();
    }
    
    
}
