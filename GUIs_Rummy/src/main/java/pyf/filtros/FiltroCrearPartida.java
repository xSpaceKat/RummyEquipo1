/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.filtros;

import entidades.Mazo;
import entidades.Partida;
import fachada.JuegoFachada;
import mvc.dto.MazoDTO;

/**
 *
 * @author galan
 */
public class FiltroCrearPartida implements IFilter<Partida, Partida> {
   
    @Override
    public Partida procesar(Partida input) {
        return input;
    }
        
}
