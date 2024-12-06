package pyf.pipebuilders;

import pyf.filtros.FiltroConsultarSeleccionAvatar;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineConsultarSeleccionAvatar {

    private final Pipe<String, Boolean> pipa;
    private IFilter filter = new FiltroConsultarSeleccionAvatar();

    public PipelineConsultarSeleccionAvatar() {
        this.pipa = new Pipe<>(filter);
    }

    public Boolean ejecutar(String avatar) {
        pipa.agregarInfo(avatar);
        pipa.enviar();

        boolean n = pipa.obtenerInfo();

        return n;
    }

}
