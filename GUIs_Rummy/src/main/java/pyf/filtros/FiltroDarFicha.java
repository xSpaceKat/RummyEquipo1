/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.filtros;

import entidades.Ficha;
import entidades.Partida;
import fachada.JuegoFachada;
import iFachada.IJuegoFachada;

/**
 *
 * @author galan
 */
public class FiltroDarFicha implements IFilter<Ficha, Boolean>{

    @Override
    public Boolean procesar(Ficha input) {
        Partida p = Partida.obtenerInstancia();
        IJuegoFachada jf = new JuegoFachada(p);
        return jf.darFichaJugadorActual(input);
    }
    
}
