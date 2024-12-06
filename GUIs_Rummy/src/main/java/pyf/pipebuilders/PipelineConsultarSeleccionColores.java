package pyf.pipebuilders;

import entidades.Grupo;
import java.awt.Color;
import pyf.filtros.FiltroConsultarSeleccionColores;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author Bell
 */
public class PipelineConsultarSeleccionColores {

    private static PipelineConsultarSeleccionColores instancia;
    private final Pipe<Grupo, Grupo> pipeAgregarColores;

    public PipelineConsultarSeleccionColores() {
        IFilter<Grupo, Grupo> filtroConsultarSeleccionColores = new FiltroConsultarSeleccionColores();

        this.pipeAgregarColores = new Pipe<>(filtroConsultarSeleccionColores);
    }

    public static PipelineConsultarSeleccionColores getInstancia() {
        if (instancia == null) {
            instancia = new PipelineConsultarSeleccionColores();
        }
        return instancia;
    }

    public Grupo ejecutar(int entero, Color color) {
        System.out.println("Iniciando pipeline...");
        Grupo juja = new Grupo();

        juja.setNumeroGrupo(entero);
        juja.setColor(color);

        // 1. Agregar los colores
        System.out.println("Agregando los colores...");
        pipeAgregarColores.agregarInfo(juja);
        pipeAgregarColores.enviar();
        Grupo jujita = pipeAgregarColores.obtenerInfo();

        if (jujita == null) {
            System.out.println("No se pudieron actualizar los colores");
            return null;
        }

        System.out.println("Color nuevo: " + jujita.getColor());
        return jujita;
    }

}
