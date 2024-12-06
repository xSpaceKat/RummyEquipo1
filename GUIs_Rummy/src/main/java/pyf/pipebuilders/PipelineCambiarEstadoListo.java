/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.pipebuilders;

import entidades.Partida;
import pyf.filtros.FiltroCambiarEstadoListo;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author OMEN
 */
public class PipelineCambiarEstadoListo {
    private final Pipe<Partida, Boolean> pipeCambiarEstadoListo; // Pipe para pasar la partida
    private boolean resultado; // Resultado del proceso

    // Constructor
    public PipelineCambiarEstadoListo() {
        IFilter<Partida, Boolean> filtroCambiarEstadoListo = new FiltroCambiarEstadoListo();
        
        this.pipeCambiarEstadoListo = new Pipe<>(filtroCambiarEstadoListo);
    }

    // Método principal para ejecutar el pipeline
    public Partida ejecutar(Partida partida) {
        System.out.println("Iniciando PipelineCambiarEstadoListo...");

        // Agregar la partida al pipe
        System.out.println("Enviando la partida al pipe...");
        pipeCambiarEstadoListo.agregarInfo(partida);

        // Validar el resultado y devolver la partida
        if (resultado) {
            System.out.println("Todos los jugadores están listos.");
        } else {
            System.out.println("Al menos un jugador no está listo.");
        }

        // Devuelve la partida procesada
        return partida;
    }
}
