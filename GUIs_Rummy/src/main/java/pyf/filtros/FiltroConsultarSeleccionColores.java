package pyf.filtros;

import entidades.Grupo;
import entidades.Jugador;
import fachada.PerfilFachada;

/**
 *
 * @author Bell
 */
public class FiltroConsultarSeleccionColores implements IFilter<Grupo, Grupo> {

    @Override
    public Grupo procesar(Grupo input) {
        Jugador jugador = new Jugador();
        PerfilFachada perfilFachada = new PerfilFachada(jugador);
        Grupo grupito = perfilFachada.cambiarColoresFichas(input.getNumeroGrupo(), input.getColor());
        return grupito;
    }   
}