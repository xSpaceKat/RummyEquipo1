/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.pipebuilders;

import entidades.Jugador;
import entidades.Partida;
import pyf.cliente.Cliente;
import pyf.filtros.FiltroUnirJugador;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineUnirJugador {
    private final Pipe<Jugador, Partida> pipeUnirJugador; 

    public PipelineUnirJugador() {
        // Crear e inicializar los filtros
        IFilter<Jugador, Partida> filtroUnirJugador = new FiltroUnirJugador();

        // Inicializar las pipas con los filtros
        this.pipeUnirJugador = new Pipe<>(filtroUnirJugador);

    }

    public Partida ejecutar(Jugador input) {
        System.out.println("Iniciando pipeline...");

        System.out.println("Procesando con FIltroUnirJugador...");
        pipeUnirJugador.agregarInfo(input);
        pipeUnirJugador.enviar();
        Partida partida= pipeUnirJugador.obtenerInfo();

        System.out.println("Pipeline finalizado.");
        return partida;
    }
}
