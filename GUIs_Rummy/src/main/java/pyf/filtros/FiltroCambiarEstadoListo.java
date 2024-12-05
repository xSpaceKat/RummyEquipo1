/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.filtros;

import entidades.Partida;
import fachada.LobbyFachada;
import iFachada.ILobbyFachada;

/**
 *
 * @author OMEN
 */
public class FiltroCambiarEstadoListo implements IFilter<Partida, Boolean>{

    @Override
    public Boolean procesar(Partida input) {
        Partida p = Partida.obtenerInstancia();
        ILobbyFachada lf = (ILobbyFachada) new LobbyFachada(p);
        return lf.estaListo();
    }

}
