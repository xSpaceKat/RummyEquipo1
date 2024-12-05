package pyf.pipebuilders;

import entidades.Combinaciones;
import entidades.Ficha;
import entidades.Partida;
import pyf.filtros.FiltroMover;
import pyf.filtros.FiltroSustituir;
import pyf.filtros.FiltroValidarCombinacion;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineConsultarMovimientos {

    private static PipelineConsultarMovimientos instancia;
    private final Pipe<Partida, Boolean> pipeValidarCombinacion;
    private final Pipe<Partida, Combinaciones> pipeSustituir;
    private final Pipe<Partida, Combinaciones> pipeMover; 
    
    public PipelineConsultarMovimientos() {
        IFilter<Partida, Boolean> filtroValidarCombinacion = new FiltroValidarCombinacion();
        IFilter<Partida, Combinaciones> filtroSustituir = new FiltroSustituir();
        IFilter<Partida, Combinaciones> filtroMover = new FiltroMover();
        
        this.pipeValidarCombinacion = new Pipe<>(filtroValidarCombinacion);
        this.pipeSustituir = new Pipe<>(filtroSustituir);
        this.pipeMover = new Pipe<>(filtroMover);
    }

    public static PipelineConsultarMovimientos getInstancia() {
        if (instancia == null) {
            instancia = new PipelineConsultarMovimientos();
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
        
        // 2. Agregar la ficha a la combinacion.
        System.out.println("Realizando la sustitucion...");
        pipeSustituir.agregarInfo(partida);
        pipeSustituir.enviar();
        Combinaciones c = pipeSustituir.obtenerInfo();
        
        if(c == null){
            System.out.println("No se logro realizar la sustitucion.");
            return partida;
        }
        
        // 3. Mover la Ficha.
        System.out.println("Moviendo la ficha...");
        pipeMover.agregarInfo(partida);
        pipeMover.enviar();
        Combinaciones f = pipeMover.obtenerInfo();
        
        if(f == null){
            System.out.println("No se pudo realizar el cambio");
            return partida;
        }
  
        return partida;
    }

}
