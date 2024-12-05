/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.filtros;

import entidades.Jugador;
import entidades.Mazo;
import entidades.Partida;
import fachada.JuegoFachada;
import mvc.dto.MazoDTO;

/**
 *
 * @author galan
 */
public class FiltroCrearMazo implements IFilter<MazoDTO, Partida> {

    public FiltroCrearMazo() {
    }

    @Override
    public Partida procesar(MazoDTO input) {
        // Lógica para procesar el MazoDTO y crear un Mazo
        Mazo mazo = new Mazo(input.getComodines(),input.getFichas());
        Partida partida= Partida.obtenerInstancia();
        partida.setMazo(mazo);
        partida.unirJugador(input.getJugador());
        return partida;
    }

}
