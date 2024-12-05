/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.pipebuilders;

import entidades.Partida;
import pyf.filtros.FiltroContadorFicha;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineContadorFicha {

    private static PipelineContadorFicha instancia;
    private final Pipe<Partida, Boolean> pipaContarFichas;

    // Constructor privado para Singleton
    private PipelineContadorFicha() {
        IFilter<Partida, Boolean> filtroContadorFicha = new FiltroContadorFicha();
        pipaContarFichas = new Pipe<>(filtroContadorFicha);
    }

    /**
     * Devuelve la única instancia de PipelineContadorFicha.
     *
     * @return instancia única de PipelineContadorFicha.
     */
    public static synchronized PipelineContadorFicha getInstancia() {
        if (instancia == null) {
            instancia = new PipelineContadorFicha();
        }
        return instancia;
    }

    /**
     * Ejecuta el pipeline para evaluar el estado de las fichas de los
     * jugadores.
     *
     * @param partida Objeto Partida a evaluar.
     * @return Partida actualizada con el resultado del procesamiento.
     */
    public Partida ejecutar(Partida partida) {
        try {
            System.out.println("Iniciando pipeline...");

            // Enviar partida al pipeline
            System.out.println("Validando si el jugador en turno se ha quedado sin fichas...");
            pipaContarFichas.agregarInfo(partida);
            pipaContarFichas.enviar();

            // Obtener el resultado del filtro
            boolean jugadorSinFichas = pipaContarFichas.obtenerInfo();

            if (jugadorSinFichas) {
                System.out.println("El jugador se ha quedado sin fichas. El jugador ha ganado.");
                partida.setEstado(true); // Marcar la partida como terminada
                return partida;
            }

            // Actualizar estado de la partida si el jugador aún tiene fichas
            System.out.println("El jugador aún tiene fichas. Continuando partida...");
            partida.setEstado(false);
            Partida partidaActualizada = Partida.obtenerInstancia();

            System.out.println("Pipeline finalizado.");
            return partidaActualizada;

        } catch (Exception e) {
            System.err.println("Error en el pipeline: " + e.getMessage());
            e.printStackTrace();
            // Retornar la partida sin modificar en caso de error
            return partida;
        }
    }
}
