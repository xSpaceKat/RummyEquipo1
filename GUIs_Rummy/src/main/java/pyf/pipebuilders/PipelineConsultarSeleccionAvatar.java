package pyf.pipebuilders;

import pyf.filtros.FiltroConsultarSeleccionNombre;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineConsultarSeleccionAvatar {

    private final Pipe<String, Boolean> pipa;
    private IFilter filter = new FiltroConsultarSeleccionNombre();

    public PipelineConsultarSeleccionAvatar() {
        this.pipa = new Pipe<>(filter);
    }

    public void ejecutar(String nombre, String avatar) {
        pipa.agregarInfo(nombre);
        pipa.agregarInfo(avatar);
        pipa.enviar();
    }

}
