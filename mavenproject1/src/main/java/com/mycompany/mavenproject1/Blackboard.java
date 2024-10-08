/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

public class Blackboard {
    private List<Cancion> canciones;
    private List<Cancion> historial;

    public Blackboard() {
        this.canciones = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void agregarAlHistorial(Cancion cancion) {
        historial.add(cancion);
    }

    public List<Cancion> getHistorial() {
        return historial;
    }

    public void mostrarCanciones() {
        if (canciones.isEmpty()) {
            System.out.println("No hay canciones disponibles.");
        } else {
            System.out.println("Lista de canciones:");
            for (int i = 0; i < canciones.size(); i++) {
                System.out.println(i + ". " + canciones.get(i));
            }
        }
    }

    public void reproducirCancion(int indice) {
        if (indice >= 0 && indice < canciones.size()) {
            Cancion cancion = canciones.get(indice);
            System.out.println("Reproduciendo: " + cancion);
            agregarAlHistorial(cancion);
        } else {
            System.out.println("Indice no valido.");
        }
    }
}