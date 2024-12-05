package pyf.pipebuilders;

import pyf.filtros.FiltroConsultarSeleccionNombre;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineConsultarSeleccionNombre {

    private final Pipe<String, Boolean> pipa;
    private IFilter filter = new FiltroConsultarSeleccionNombre();

    public PipelineConsultarSeleccionNombre() {
        this.pipa = new Pipe<>(filter);
    }

    public void ejecutar(String nombre) {
        pipa.agregarInfo(nombre);
        pipa.enviar();
    }

}
