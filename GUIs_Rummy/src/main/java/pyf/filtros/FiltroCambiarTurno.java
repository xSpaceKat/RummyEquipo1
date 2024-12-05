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
public class FiltroCambiarTurno implements IFilter<Boolean, Partida>{

    @Override
    public Partida procesar(Boolean input) {
        Partida p = Partida.obtenerInstancia();
        IJuegoFachada jf = new JuegoFachada(p);
        if (input = true) {
            jf.pasarTurno();
            System.out.println("Cambio de turno realizado.");
        } else{
            System.out.println("Fallo al cambiar de turno.");
        }
        return p;
    }
    
}
