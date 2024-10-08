/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Cyber Centro 08
 */
public class Cancion {
    private String nombre;
    private String artista;
    private String genero;
    private int calificacion;

    public Cancion(String nombre, String artista, String genero, int calificacion) {
        this.nombre = nombre;
        this.artista = artista;
        this.genero = genero;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArtista() {
        return artista;
    }

    public String getGenero() {
        return genero;
    }

    public int getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        return nombre + " - " + artista + " [" + genero + "] (Calificacion: " + calificacion + ")";
    }
}