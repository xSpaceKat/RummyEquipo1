/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.pipebuilders;

import entidades.Mazo;
import entidades.Partida;
import java.util.ArrayList;
import java.util.List;
import mvc.dto.MazoDTO;
import pyf.cliente.Cliente;
import pyf.filtros.FiltroCrearMazo;
import pyf.filtros.FiltroCrearPartida;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineCrearPartida {
    private final Pipe<MazoDTO, Partida> pipeCrearMazo;     // Pipa para convertir MazoDTO a Partida
    private final Pipe<Partida, Partida> pipeCrearPartida; // Pipa para procesar la Partida

    public PipelineCrearPartida() {
        // Crear e inicializar los filtros
        IFilter<MazoDTO, Partida> filtroCrearMazo = new FiltroCrearMazo();
        IFilter<Partida, Partida> filtroCrearPartida = new FiltroCrearPartida();

        // Inicializar las pipas con los filtros
        this.pipeCrearMazo = new Pipe<>(filtroCrearMazo);
        this.pipeCrearPartida = new Pipe<>(filtroCrearPartida);
    }

    public Partida ejecutar(MazoDTO input) {
        System.out.println("Iniciando pipeline...");

        // 1. Paso por la primera pipa (MazoDTO -> Mazo)
        System.out.println("Procesando con FiltroCrearMazo...");
        pipeCrearMazo.agregarInfo(input);
        pipeCrearMazo.enviar();
        Partida partida= pipeCrearMazo.obtenerInfo();

        // 2. Paso por la segunda pipa (Mazo -> Partida)
        System.out.println("Procesando con FiltroCrearPartida...");
        pipeCrearPartida.agregarInfo(partida);
        pipeCrearPartida.enviar();
        Partida partida2 = pipeCrearPartida.obtenerInfo();

        System.out.println("Pipeline finalizado.");
        Cliente cliente= Cliente.getInstancia();
        cliente.enviarSerializado(partida);
        return cliente.getPartidaCliente();
    }
}
