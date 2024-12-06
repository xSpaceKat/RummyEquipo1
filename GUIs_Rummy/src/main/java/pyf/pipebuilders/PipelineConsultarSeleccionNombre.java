package pyf.pipebuilders;

import entidades.Jugador;
import pyf.filtros.FiltroConsultarSeleccionNombre;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineConsultarSeleccionNombre {

    private static PipelineConsultarSeleccionNombre instancia;
    private final Pipe<Jugador, Jugador> pipaAgregarNombre;

    public PipelineConsultarSeleccionNombre() {
        IFilter<Jugador, Jugador> filtroConsultarSeleccionNombre = new FiltroConsultarSeleccionNombre();

        this.pipaAgregarNombre = new Pipe<>(filtroConsultarSeleccionNombre);
    }

    public static PipelineConsultarSeleccionNombre getInstancia() {
        if (instancia == null) {
            instancia = new PipelineConsultarSeleccionNombre();
        }
        return instancia;
    }

    public Jugador ejecutar(String nombre) {
        System.out.println("Iniciando pipeline...");

        Jugador jugador = new Jugador();
        jugador.setNombre(nombre);

        //1. Agregar el nombre
        System.out.println("Agregando el nombre...");
        pipaAgregarNombre.agregarInfo(jugador);
        pipaAgregarNombre.enviar();
        Jugador juja = pipaAgregarNombre.obtenerInfo();

        if (juja == null) {
            System.out.println("No se pudo actualizar el nombre");
            return null;
        }

        return juja;
    }

}
