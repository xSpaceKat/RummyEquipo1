/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.List;

public class Historial {
    private List<Cancion> historialReproducciones;

    public Historial(List<Cancion> historialReproducciones) {
        this.historialReproducciones = historialReproducciones;
    }

    public void mostrarHistorial() {
        if (historialReproducciones.isEmpty()) {
            System.out.println("El historial esta vacio.");
        } else {
            System.out.println("Historial de canciones reproducidas:");
            for (Cancion cancion : historialReproducciones) {
                System.out.println(cancion);
            }
        }
    }
}
