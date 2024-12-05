/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada;

import entidades.Partida;
import entidades.Mazo;

/**
 *
 * @author galan
 */
public class ConfigurarPartidaFachada {
    private Partida partida;

    // Constructor que recibe la partida
    public ConfigurarPartidaFachada(Partida partida) {
        this.partida = partida;
    }

    // Establecer rangos de la partida
    public void establecerRangos(int rango) {
        partida.getMazo().setRangos(rango);
        System.out.println("Se han establecido los rangos en el mazo a " + rango);
    }

    // Establecer la cantidad de comodines en el mazo
    public void establecerComodines(int comodines) {
        partida.getMazo().setCantidadComodines(comodines);
        System.out.println("Se han establecido " + comodines + " comodines en el mazo.");
    }

    // Crear la partida (asociando la partida con los jugadores y configurando el tablero)
    public void crearPartida() {
        System.out.println("La partida ha sido configurada.");
        partida.setEstado(true);
    }
}
