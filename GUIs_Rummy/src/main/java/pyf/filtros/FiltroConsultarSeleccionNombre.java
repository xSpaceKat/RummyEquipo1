package pyf.filtros;

import entidades.Jugador;
import fachada.PerfilFachada;

/**
 *
 * @author galan
 */
public class FiltroConsultarSeleccionNombre implements IFilter<Jugador, Jugador> {

    public FiltroConsultarSeleccionNombre() {
    }

    @Override
    public Jugador procesar(Jugador dato) {
        PerfilFachada perfilFachada = new PerfilFachada(dato);
        Jugador actualizado = perfilFachada.verificarSeleccionNombre(dato.getNombre());

        return actualizado;
    }

}
