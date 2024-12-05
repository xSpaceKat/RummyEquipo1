package fachada;

import entidades.Combinaciones;
import entidades.Partida;
import entidades.Ficha;
import entidades.Grupo;
import entidades.Turno;
import iFachada.IJuegoFachada;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author galan
 */
public class JuegoFachada implements IJuegoFachada {

    private Partida partida;
    private Grupo grupo;

    // Constructor que recibe la partida
    public JuegoFachada(Partida partida) {
        this.partida = partida;
    }

    // Inicializar el tablero
    @Override
    public boolean inicializarTablero() {
        // Implementar la lógica de inicialización del tablero
        System.out.println("Tablero inicializado.");
        return true;
    }

    // Extraer una ficha del mazo
    @Override
    public Ficha extraerFicha() {
        Ficha ficha = partida.getMazo().sacarFicha();
        System.out.println("Ficha extraída: " + ficha);
        return ficha;
    }

    // Dar ficha al jugador actual
    @Override
    public boolean darFichaJugadorActual(Ficha ficha) {
        // Implementar la lógica de asignación de ficha al jugador actual
        System.out.println("Se ha dado la ficha al jugador actual.");
        return true;
    }

    // Pasar el turno
    @Override
    public void pasarTurno() {
        partida.getTurnos().siguiente();
    }

    // Asignar fichas Azar
    @Override
    public boolean asignarFichasAzar() {
        partida.getMazo().asignarFichas();
        return true;
    }

    // Método para asignar turnos al azar
    @Override
    public boolean asignarTurnos() {
        if (partida.getJugadores() == null || partida.getJugadores().size() == 0) {
            System.out.println("No hay jugadores para asignar turnos.");
            return false;
        }

        // Mezclar aleatoriamente la lista de jugadores
        Collections.shuffle(partida.getJugadores());

        // Actualizar el turno en la clase Turno
        partida.setTurnos(new Turno(partida.getJugadores()));
        System.out.println("Turnos asignados al azar: ");
        for (int i = 0; i < partida.getJugadores().size(); i++) {
            System.out.println("Jugador " + partida.getJugadores().get(i).getNombre() + " tiene el turno " + i);
        }

        return true;
    }

    // Agregar combinación
    @Override
    public Combinaciones agregarCombinacion(List<Ficha> fichas) {
        Combinaciones c = new Combinaciones();
        c.setFichas(fichas);
        return c;
    }

    public boolean validaCombinacion() {
        return partida.getTablero().getCombinaciones().contains(grupo.getNumeroGrupo());
    }

    public Combinaciones separarGrupo() {
        Combinaciones combinaciones = (Combinaciones) partida.getTablero().getCombinaciones();
        List<Ficha> combi = combinaciones.getFichas();

        List<Ficha> primerosTres = null;
        List<Ficha> ultimosTres = null;

        for (int i = 0; i < 3; i++) {
            primerosTres.add(combi.get(i));
        }

        for (int i = combi.size() - 3; i < combi.size(); i++) {
            ultimosTres.add(combi.get(i));
        }

        Combinaciones c1 = agregarCombinacion(primerosTres);
        Combinaciones c2 = agregarCombinacion(ultimosTres);

        return c2;
    }

    //Revisa si hay fichas en el mazo o no
    @Override
    public boolean esMazoVacio() {
        //Accede al mazo de la partida
        return partida.getMazo().esMazoVacio();
    }

}
