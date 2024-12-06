package pyf.filtros;

import entidades.Jugador;
import fachada.PerfilFachada;

/**
 *
 * @author galan
 */
public class FiltroConsultarSeleccionAvatar implements IFilter<String, Boolean> {

    Jugador jugador = new Jugador();
    PerfilFachada perfilFachada = new PerfilFachada(jugador);

    public FiltroConsultarSeleccionAvatar() {
    }

    @Override
    public Boolean procesar(String dato) {
        boolean n = perfilFachada.verificarSeleccionAvatar(dato);

        return n;
    }

}
