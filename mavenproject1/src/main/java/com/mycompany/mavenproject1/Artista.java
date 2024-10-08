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
public class Artista {
    public List<Cancion> filtrarPorArtista(List<Cancion> canciones, String artista) {
        List<Cancion> resultado = new ArrayList<>();
        for (Cancion cancion : canciones) {
            if (cancion.getArtista().equalsIgnoreCase(artista)) {
                resultado.add(cancion);
            }
        }
        return resultado;
    }
}
