package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.awt.Color;

/**
 *
 * @author galan
 */
public class Mazo implements Serializable {

    private List<Ficha> mazo;
    private int rangos;
    private int cantidadComodines;

    // Constructor
    public Mazo(List<Ficha> mazo, int rangos, int cantidadComodines) {
        this.mazo = mazo;
        this.rangos = rangos;
        this.cantidadComodines = cantidadComodines;
    }

    public Mazo(int rangos, int cantidadComodines) {
        this.rangos = rangos;
        this.cantidadComodines = cantidadComodines;
    }

    
    public Mazo() {
    }

    public List<Ficha> getMazo() {
        return mazo;
    }

    public void setMazo(List<Ficha> mazo) {
        this.mazo = mazo;
    }

    public int getRangos() {
        return rangos;
    }

    public void setRangos(int rangos) {
        this.rangos = rangos;
    }

    public int getCantidadComodines() {
        return cantidadComodines;
    }

    public void setCantidadComodines(int cantidadComodines) {
        this.cantidadComodines = cantidadComodines;
    }

    public Ficha sacarFicha() {
        if (esMazoVacio()) {
            throw new IllegalArgumentException("La lista está vacía");
        }

        // Crear un generador de números aleatorios
        Random random = new Random();

        // Generar un índice al azar dentro del rango de la lista
        int randomIndex = random.nextInt(mazo.size());

        // Obtener el número en ese índice
        Ficha fichaObtenida = mazo.get(randomIndex);

        // Eliminar el número de la lista
        mazo.remove(randomIndex);

        // Devolver el número eliminado
        return fichaObtenida;
    }

    public void agregarFicha(Ficha ficha) {
        mazo.add(ficha);
    }

    public boolean esMazoVacio() {
        return mazo.isEmpty();
    }

    public void asignarFichas() {
        mazo.clear(); // Limpia el mazo antes de asignar fichas

        List<Grupo> grupos = new ArrayList<>();
        grupos.add(new Grupo(1));
        grupos.add(new Grupo( 2));
        grupos.add(new Grupo(3));
        grupos.add(new Grupo(4));

        // Generar fichas normales para cada grupo asignado 
        for (Grupo grupo : grupos) { // Iterar por los grupos 
            for (int numero = 1; numero <= rangos; numero++) {
                // Crear una ficha normal para el número y grupo
                FichaNormal fichaNormal = new FichaNormal(numero, grupo);
                mazo.add(fichaNormal); // Agregar ficha al mazo
            }
        }

        // Generar comodines
        for (int i = 0; i < cantidadComodines; i++) {
            Ficha comodin = new Comodin();
            mazo.add(comodin);
        }

        // Mezclar el mazo
        Collections.shuffle(mazo);

        // Imprimir las fichas generadas
        System.out.println("Fichas asignadas exitosamente:");
        for (Ficha ficha : mazo) {
            if (ficha instanceof FichaNormal) {
                FichaNormal fichaNormal = (FichaNormal) ficha;
                System.out.println("Ficha Normal: Número " + fichaNormal.getValor()
                        + ", Grupo: " + fichaNormal.getGrupo().getNumeroGrupo()
                        + ", Color: " + fichaNormal.getGrupo().getColor());
            } else if (ficha instanceof Comodin) {
                System.out.println("Comodín");
            }
        }
    }

}
