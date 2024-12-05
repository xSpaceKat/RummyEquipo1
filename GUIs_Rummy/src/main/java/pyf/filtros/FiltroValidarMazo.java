/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.filtros;

import entidades.Partida;
import fachada.JuegoFachada;
import iFachada.IJuegoFachada;

/**
 *
 * @author galan
 */
public class FiltroValidarMazo implements IFilter<Partida, Boolean>{

    @Override
    public Boolean procesar(Partida input) {
        Partida p = Partida.obtenerInstancia();
        IJuegoFachada jf = new JuegoFachada(p);
        
        return jf.esMazoVacio();
    }
    
}
