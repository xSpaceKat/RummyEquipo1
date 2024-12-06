/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.filtros;

import entidades.Jugador;
import entidades.Mazo;
import entidades.Partida;
import fachada.LobbyFachada;
import pyf.cliente.Cliente;

/**
 *
 * @author galan
 */
public class FiltroUnirJugador implements IFilter<Jugador, Partida>{

    public FiltroUnirJugador() {
    }

    @Override
    public Partida procesar(Jugador input) {
        Partida partida= Cliente.getInstancia().getPartidaCliente();
        LobbyFachada fachada= new LobbyFachada(partida);
        partida.unirJugador(input);
        return partida;
    }
    
}
