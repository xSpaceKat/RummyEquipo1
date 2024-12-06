package pyf.pipebuilders;

import entidades.Jugador;
import pyf.filtros.FiltroConsultarSeleccionAvatar;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineConsultarSeleccionAvatar {

    private static PipelineConsultarSeleccionAvatar instancia;
    private final Pipe<Jugador, Jugador> pipaCambiarAvatar;

    public PipelineConsultarSeleccionAvatar() {
        IFilter<Jugador, Jugador> filtroConsultarSeleccionAvatar = new FiltroConsultarSeleccionAvatar();

        this.pipaCambiarAvatar = new Pipe<>(filtroConsultarSeleccionAvatar);
    }

    public static PipelineConsultarSeleccionAvatar getInstancia() {
        if (instancia == null) {
            instancia = new PipelineConsultarSeleccionAvatar();
        }
        return instancia;
    }

    public Jugador ejecutar(String avatar) {
        System.out.println("Iniciando pipeline...");

        Jugador jugador = new Jugador();
        jugador.setAvatar(avatar);

        pipaCambiarAvatar.agregarInfo(jugador);
        pipaCambiarAvatar.enviar();
        Jugador juja = pipaCambiarAvatar.obtenerInfo();

        if (juja == null) {
            System.out.println("No se pudo actualizar el avatar");
            return juja;
        }

        return juja;
    }

}
