package pyf.filtros;

import entidades.Combinaciones;
import entidades.Partida;
import fachada.JuegoFachada;
import iFachada.IJuegoFachada;

/**
 *
 * @author Katt
 */
public class FiltroSepararGrupo implements IFilter<Partida, Combinaciones> {

    @Override
    public Combinaciones procesar(Partida input) {
        Partida p = Partida.obtenerInstancia();
        IJuegoFachada jf = new JuegoFachada(p);

        return jf.separarGrupo();
    }

}
