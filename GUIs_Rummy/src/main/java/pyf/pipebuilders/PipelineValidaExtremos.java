package pyf.pipebuilders;

import entidades.Combinaciones;
import entidades.Partida;
import pyf.filtros.FiltroArrastrarExtremo;
import pyf.filtros.FiltroCambiarFichaExtremo;
import pyf.filtros.FiltroValidarCombinacion;
import pyf.filtros.FiltroValidarExtremos;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineValidaExtremos {

    private static PipelineValidaExtremos instancia;
    private final Pipe<Partida, Boolean> pipeValidarCombinacion;
    private final Pipe<Partida, Combinaciones> pipeArrastrarExtremo;
    private final Pipe<Partida, Boolean> pipeValidarExtremos;
    private final Pipe<Partida, Combinaciones> pipeCambiarFichaExtremo;

    public PipelineValidaExtremos() {
        IFilter<Partida, Boolean> filtroValidarCombinacion = new FiltroValidarCombinacion();
        IFilter<Partida, Combinaciones> filtroArrastrarExtremo = new FiltroArrastrarExtremo();
        IFilter<Partida, Boolean> filtroValidarExtremos = new FiltroValidarExtremos();
        IFilter<Partida, Combinaciones> filtroCambiarFichaExtremo = new FiltroCambiarFichaExtremo();

        this.pipeValidarCombinacion = new Pipe<>(filtroValidarCombinacion);
        this.pipeArrastrarExtremo = new Pipe<>(filtroArrastrarExtremo);
        this.pipeValidarExtremos = new Pipe<>(filtroValidarExtremos);
        this.pipeCambiarFichaExtremo = new Pipe<>(filtroCambiarFichaExtremo);
    }

    public static PipelineValidaExtremos getInstancia() {
        if (instancia == null) {
            instancia = new PipelineValidaExtremos();
        }
        return instancia;
    }

    public Partida ejecutar(Partida partida) {
        System.out.println("Iniciando pipeline...");

        // 1. Valida
        System.out.println("Validando la combinacion...");
        pipeValidarCombinacion.agregarInfo(partida);
        pipeValidarCombinacion.enviar();
        Boolean combinacionValidada = pipeValidarCombinacion.obtenerInfo();

        if (combinacionValidada) {
            System.out.println("La combinacion no es valida para realizar esta accion!");
            return partida; // Salir
        }

        // 2. 
        System.out.println("Agregando una ficha al extremo...");
        pipeArrastrarExtremo.agregarInfo(partida);
        pipeArrastrarExtremo.enviar();
        Combinaciones c = pipeArrastrarExtremo.obtenerInfo();

        if (c == null) {
            System.out.println("Hubo un error al cambiar la ficha");
            return partida;
        }

        //3
        System.out.println("Validando los extremos...");
        pipeValidarExtremos.agregarInfo(partida);
        pipeValidarExtremos.enviar();
        Boolean b = pipeValidarExtremos.obtenerInfo();

        if (b) {
            System.out.println("No se logro arrastrar con exito");
            return partida;
        }

        //4
        System.out.println("Cambiando ficha del extremo...");
        pipeCambiarFichaExtremo.agregarInfo(partida);
        pipeCambiarFichaExtremo.enviar();
        Combinaciones cc = pipeCambiarFichaExtremo.obtenerInfo();

        if (cc == null) {
            System.out.println("No se pudo mover la ficha del extremo a otra combinacion");
            return partida;
        }

        return partida;

    }

}
