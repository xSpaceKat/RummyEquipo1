package fachada;

import entidades.Grupo;
import java.awt.Color;
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

    public Grupo cambiarColoresFichas(int numeroGrupo, Color nuevoColor) {
        jugador.cambiarColorGrupo(numeroGrupo, nuevoColor);
        Grupo grupoActualizado = new Grupo();
        grupoActualizado.setColor(nuevoColor);
        grupoActualizado.setNumeroGrupo(numeroGrupo);
        return grupoActualizado;
    }
}
