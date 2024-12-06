package pyf.filtros;

import entidades.Jugador;
import fachada.PerfilFachada;

/**
 *
 * @author galan
 */
public class FiltroConsultarSeleccionAvatar implements IFilter<Jugador, Jugador> {

    public FiltroConsultarSeleccionAvatar() {
    }

    @Override
    public Jugador procesar(Jugador dato) {
        PerfilFachada perfilFachada = new PerfilFachada(dato);
        Jugador actualizado = perfilFachada.verificarSeleccionAvatar(dato.getAvatar());

        return actualizado;
    }

}
