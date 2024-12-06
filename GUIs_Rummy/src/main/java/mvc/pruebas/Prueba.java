package mvc.pruebas;

import entidades.Partida;
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
        
        Partida partida= Partida.obtenerInstancia();
        
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
