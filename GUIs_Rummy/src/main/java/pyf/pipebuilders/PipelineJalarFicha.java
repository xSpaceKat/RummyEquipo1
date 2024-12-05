/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.pipebuilders;

import entidades.Ficha;
import entidades.Partida;
import pyf.filtros.FiltroCambiarTurno;
import pyf.filtros.FiltroDarFicha;
import pyf.filtros.FiltroJalarFicha;
import pyf.filtros.FiltroValidarMazo;
import pyf.filtros.IFilter;
import pyf.pipas.Pipe;

/**
 *
 * @author galan
 */
public class PipelineJalarFicha {

    // Instancia única de la clase
    private static PipelineJalarFicha instancia;
    private final Pipe<Partida, Boolean> pipeValidarMazo;     // Pipa para ver si el mazo está vacío o no
    private final Pipe<Partida, Ficha> pipeJalarFicha; // Pipa para jalar una ficha del mazo
    private final Pipe<Ficha, Boolean> pipeDarFicha; // Pipa que otorga la ficha al jugador
    private final Pipe<Boolean, Partida> pipePasarTurno; // Pipa que pasa el turno al próximo jugador
    
    // Constructor privado
    private PipelineJalarFicha() {
        // Inicialización si es necesario
        // Crear e inicializar los filtros
        IFilter<Partida, Boolean> filtroValidarMazo = new FiltroValidarMazo();
        IFilter<Partida, Ficha> filtroJalarFicha = new FiltroJalarFicha();
        IFilter<Ficha, Boolean> filtroDarFicha = new FiltroDarFicha();
        IFilter<Boolean, Partida> filtroCambiarTurno = new FiltroCambiarTurno();

        // Inicializar las pipas con los filtros
        this.pipeValidarMazo = new Pipe<>(filtroValidarMazo);
        this.pipeJalarFicha = new Pipe<>(filtroJalarFicha);
        this.pipeDarFicha = new Pipe<>(filtroDarFicha);
        this.pipePasarTurno = new Pipe<>(filtroCambiarTurno);

    }

    // Método estático para obtener la única instancia
    public static PipelineJalarFicha getInstancia() {
        if (instancia == null) {
            instancia = new PipelineJalarFicha();
        }
        return instancia;
    }

    public Partida ejecutar(Partida partida) {
        System.out.println("Iniciando pipeline...");

        // 1. Validar si el mazo está vacío
        System.out.println("Validando si el mazo está vacío...");
        pipeValidarMazo.agregarInfo(partida);
        pipeValidarMazo.enviar();
        Boolean esMazoVacio = pipeValidarMazo.obtenerInfo();

        if (esMazoVacio) {
            System.out.println("El mazo está vacío. No se puede jalar una ficha.");
            return partida; // Salir si el mazo está vacío
        }

        // 2. Jalar una ficha del mazo
        System.out.println("Extrayendo una ficha del mazo...");
        pipeJalarFicha.agregarInfo(partida);
        pipeJalarFicha.enviar();
        Ficha fichaJalada = pipeJalarFicha.obtenerInfo();

        if (fichaJalada == null) {
            System.out.println("No se pudo extraer una ficha.");
            return partida; // Salir si no se pudo extraer una ficha
        }

        // 3. Dar la ficha al jugador actual
        System.out.println("Asignando la ficha al jugador actual...");
        pipeDarFicha.agregarInfo(fichaJalada);
        pipeDarFicha.enviar();
        Boolean fichaAsignada = pipeDarFicha.obtenerInfo();

        if (!fichaAsignada) {
            System.out.println("No se pudo asignar la ficha al jugador actual.");
            return partida; // Salir si no se pudo asignar la ficha
        }

        // 4. Pasar el turno al siguiente jugador
        System.out.println("Cambiando el turno al siguiente jugador...");
        pipePasarTurno.agregarInfo(fichaAsignada);
        pipePasarTurno.enviar();
        Partida partidaActualizada = pipePasarTurno.obtenerInfo();

        System.out.println("Pipeline finalizado.");
        return partidaActualizada;
    }

}
