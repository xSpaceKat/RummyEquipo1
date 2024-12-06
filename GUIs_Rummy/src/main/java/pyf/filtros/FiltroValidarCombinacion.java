package pyf.filtros;

import entidades.Partida;
import fachada.JuegoFachada;
import iFachada.IJuegoFachada;

/**
 *
 * @author Katt
 */
public class FiltroValidarCombinacion implements IFilter<Partida, Boolean> {

    @Override
    public Boolean procesar(Partida input) {
        Partida p = Partida.obtenerInstancia();
        IJuegoFachada jf = new JuegoFachada(p);

        return jf.validaCombinacion();
    }

}
