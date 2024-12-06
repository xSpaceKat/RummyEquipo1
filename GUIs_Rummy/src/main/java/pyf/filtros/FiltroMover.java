package pyf.filtros;

import entidades.Combinaciones;
import entidades.Ficha;
import entidades.Partida;
import fachada.JuegoFachada;
import iFachada.IJuegoFachada;

/**
 *
 * @author Katt
 */
public class FiltroMover implements IFilter<Partida, Combinaciones> {

    @Override
    public Combinaciones procesar(Partida input) {
        Partida p = Partida.obtenerInstancia();
        IJuegoFachada jf = new JuegoFachada(p);
        
        return jf.mover();
    }
    
}
