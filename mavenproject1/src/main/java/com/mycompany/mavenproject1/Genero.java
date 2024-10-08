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
public class Genero {
    public List<Cancion> filtrarPorGenero(List<Cancion> canciones, String genero) {
        List<Cancion> resultado = new ArrayList<>();
        for (Cancion cancion : canciones) {
            if (cancion.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(cancion);
            }
        }
        return resultado;
    }
}
