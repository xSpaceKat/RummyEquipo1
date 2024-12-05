/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import entidades.Color;
import entidades.Jugador;

/**
 *
 * @author galan
 */
public class PerfilFachada {
    private Jugador jugador;

    // Constructor que recibe al jugador que se va a modificar
    public PerfilFachada(Jugador jugador) {
        this.jugador = jugador;
    }

    public void cambiarFoto(String nuevaFoto) {
        jugador.setAvatar(nuevaFoto);
        System.out.println("Foto cambiada con éxito.");
    }

    public void cambiarNombre(String nuevoNombre) {
        jugador.setNombre(nuevoNombre);
        System.out.println("Nombre cambiado con éxito.");
    }

    public void cambiarColoresFichas(int numeroGrupo, Color nuevoColor) {
        jugador.cambiarColorGrupo(numeroGrupo, nuevoColor);
        System.out.println("Color de ficha cambiados con éxito.");
    }
}
