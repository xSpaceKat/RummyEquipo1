package pyf.pipebuilders;

import entidades.Combinaciones;
import entidades.Tablero;
import pyf.filtros.FiltroValidarSeparacion;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineValidarSeparacion {

    private final Pipe<Combinaciones, Tablero> pipeSeparar;
    private IFilter filter = (IFilter) new FiltroValidarSeparacion();

    public PipelineValidarSeparacion(Pipe<Combinaciones, Tablero> pipeSeparar) {
        this.pipeSeparar = new Pipe<>(filter);
    }
    
    // cambiar por tablero
    public void ejecutar(Combinaciones input){
        pipeSeparar.agregarInfo(input);
        
        pipeSeparar.enviar();

//        Deberia ser con el tablero en vez de la partida
//        Cliente cliente= Cliente.getInstancia();
//        cliente.enviarSerializado(partida);
//        return cliente.getPartidaCliente();
        
        
    }
    
    

}
