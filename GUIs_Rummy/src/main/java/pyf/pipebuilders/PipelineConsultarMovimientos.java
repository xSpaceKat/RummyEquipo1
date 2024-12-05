package pyf.pipebuilders;

import entidades.Combinaciones;
import entidades.Tablero;
import pyf.filtros.FiltroConsultarMovimiento;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineConsultarMovimientos {

    private final Pipe<Combinaciones, Tablero> pipeMovimientos;
    private IFilter filter = (IFilter) new FiltroConsultarMovimiento();

    public PipelineConsultarMovimientos() {
        this.pipeMovimientos = new Pipe<>(filter);
    }

    // Quitar void y poner el Tablero
    public void ejecutar(Combinaciones input) {
        pipeMovimientos.agregarInfo(input);
        pipeMovimientos.enviar();

//        Deberua ser con el tablero en vez de la partida
//        Cliente cliente= Cliente.getInstancia();
//        cliente.enviarSerializado(partida);
//        return cliente.getPartidaCliente();
    }

}
