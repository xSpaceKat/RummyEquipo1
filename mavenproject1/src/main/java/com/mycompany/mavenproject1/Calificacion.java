/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cyber Centro 08
 */
public class Calificacion {
    public List<Cancion> filtrarPorCalificacion(List<Cancion> canciones, int calificacionMinima) {
        List<Cancion> resultado = new ArrayList<>();
        for (Cancion cancion : canciones) {
            if (cancion.getCalificacion() >= calificacionMinima) {
                resultado.add(cancion);
            }
        }
        return resultado;
    }
}
