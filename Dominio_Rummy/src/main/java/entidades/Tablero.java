package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author galan
 */
public class Tablero implements Serializable{
    private List<Combinaciones> combinaciones;

    public Tablero() {
        combinaciones= new ArrayList<>();
    }

    public Tablero(List<Combinaciones> combinaciones) {
        this.combinaciones = combinaciones;
    }

    public List<Combinaciones> getCombinaciones() {
        return combinaciones;
    }

    public void setCombinaciones(List<Combinaciones> combinaciones) {
        this.combinaciones = combinaciones;
    }
    
    public void agregarCombinacion(Combinaciones combinacion){
        combinaciones.add(combinacion);
    }
}
