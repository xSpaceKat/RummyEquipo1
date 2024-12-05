package pyf.filtros;

import entidades.Combinaciones;
import entidades.Tablero;

/**
 *
 * @author galan
 */
public class FiltroConsultarMovimiento implements IFilter<Combinaciones, Tablero> {

    public FiltroConsultarMovimiento() {
    }

    @Override
    public Tablero procesar(Combinaciones input) {
        Tablero tablero = new Tablero();
        
        tablero.agregarCombinacion(input);
        
        // Debeeria haber uno para mover suponiendo (Agrega y se sustituye)
        // tablero.moverCombinacion(input)
        
        return tablero;

    }

}
