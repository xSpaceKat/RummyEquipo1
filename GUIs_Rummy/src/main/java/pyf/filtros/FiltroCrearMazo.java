/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.filtros;

import entidades.Jugador;
import entidades.Mazo;
import entidades.Partida;
import fachada.JuegoFachada;
import fachada.LobbyFachada;
import iFachada.IJuegoFachada;
import iFachada.ILobbyFachada;
import mvc.dto.MazoDTO;
import pyf.cliente.Cliente;

/**
 *
 * @author galan
 */
public class FiltroCrearMazo implements IFilter<MazoDTO, Partida> {
    ILobbyFachada lobbyFachada;
    
    public FiltroCrearMazo() {
    }

    @Override
    public Partida procesar(MazoDTO input) {
        // Lógica para procesar el MazoDTO y crear un Mazo
        Mazo mazo = new Mazo(input.getComodines(),input.getFichas());
        Partida partidaCliente= Cliente.getInstancia().getPartidaCliente();
        lobbyFachada= new LobbyFachada(partidaCliente);
        partidaCliente.setMazo(mazo);
        lobbyFachada.unirJugador(input.getJugador());
        Cliente.getInstancia().getPartidaCliente().actualizarInstancia(partidaCliente);
        return partidaCliente;
    }

}
