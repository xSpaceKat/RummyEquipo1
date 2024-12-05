package fachada;

import entidades.Color;
import entidades.Jugador;

/**
 *
 * @author galan
 */
public class PerfilFachada {

    private Jugador jugador;

    // Constructor que recibe al jugador que se va a modificar
    public PerfilFachada(Jugador jugador) {
        this.jugador = jugador;
    }

    public void cambiarFoto(String nuevaFoto) {
        jugador.setAvatar(nuevaFoto);
        System.out.println("Foto cambiada con éxito.");
    }

    public void cambiarNombre(String nuevoNombre) {
        jugador.setNombre(nuevoNombre);
        System.out.println("Nombre cambiado con éxito.");
    }

    public void cambiarColoresFichas(int numeroGrupo, Color nuevoColor) {
        jugador.cambiarColorGrupo(numeroGrupo, nuevoColor);
        System.out.println("Color de ficha cambiados con éxito.");
    }

    public boolean verificarSeleccionNombre(String dato) {
        if (dato == null) {
            System.out.println("El nombre esta vacio!");
            jugador.setNombre("Jugador");
            return false;
        } else {
            jugador.setNombre(dato);
            System.out.println("El nombre del jugador se guardo con exito :)");
            System.out.println(jugador.getNombre().toString());
            return true;
        }
    }
}
