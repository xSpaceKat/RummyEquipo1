package pyf.filtros;

import entidades.Jugador;
import fachada.PerfilFachada;

/**
 *
 * @author galan
 */
public class FiltroConsultarSeleccionNombre implements IFilter<String, Boolean> {

    Jugador jugador = new Jugador();
    PerfilFachada perfilFachada = new PerfilFachada(jugador);
    
    public FiltroConsultarSeleccionNombre() {
    }

    @Override
    public Boolean procesar(String dato) {
        boolean n = perfilFachada.verificarSeleccionNombre(dato);
        
        return n;
    }

}
