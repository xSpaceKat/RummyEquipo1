/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mvc.pruebas;

import mvc.controladores.ControladorMenu;
import mvc.modelos.ModeloMenu;
import mvc.vistas.JMenu;

/**
 *
 * @author galan
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cargamos modelo
        ModeloMenu m = new ModeloMenu();
        
        //Cargamos controlador y le asignamos qué modelo controlar
        ControladorMenu c = new ControladorMenu(m);
        
        //Cargamos 2 vistas y asignamos cual queremos que sea su controlador 
        JMenu v = new JMenu(c);
        
        //añadimos observadores al modelo. En este caso, dos vistas.
        m.addObservador(v);
    }
    
}
