package pyf.pipebuilders;

import entidades.Combinaciones;
import entidades.Partida;
import pyf.filtros.FiltroSepararGrupo;
import pyf.filtros.FiltroValidarCombinacion;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineValidarSeparacion {

    private static PipelineValidarSeparacion instancia;
    private final Pipe<Partida, Boolean> pipeValidarCombinacion;
    private final Pipe<Partida, Combinaciones> pipeSeparar;

    private PipelineValidarSeparacion() {
        IFilter<Partida, Boolean> filtroValidarCombinacion = new FiltroValidarCombinacion();
        IFilter<Partida, Combinaciones> filtroSeparar = new FiltroSepararGrupo();

        this.pipeValidarCombinacion = new Pipe<>(filtroValidarCombinacion);
        this.pipeSeparar = new Pipe<>(filtroSeparar);
    }

    // Método estático para obtener la única instancia
    public static PipelineValidarSeparacion getInstancia() {
        if (instancia == null) {
            instancia = new PipelineValidarSeparacion();
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
        
        //2. Separa los grupos
        System.out.println("Separando los grupos de combinacion...");
        pipeSeparar.agregarInfo(partida);
        pipeSeparar.enviar();
        Combinaciones c2 = pipeSeparar.obtenerInfo();
        
        if (c2 == null) {
            System.out.println("No se pudo separar la combinacion.");
            return partida; // Salir
        }
        
        System.out.println("Pipeline finalizado.");
        return partida;
    }

}
