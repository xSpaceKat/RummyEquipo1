package mvc.pruebas;

import entidades.Partida;
import mvc.controladores.ControladorPerfil;
import mvc.modelos.ModeloPerfil;
import mvc.vistas.JPerfil;

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
        ModeloPerfil m = new ModeloPerfil();
        
        //Cargamos controlador y le asignamos qué modelo controlar
        ControladorPerfil c = new ControladorPerfil(m);
        
        //Cargamos 2 vistas y asignamos cual queremos que sea su controlador 
        JPerfil v = new JPerfil(c);
        
        //añadimos observadores al modelo. En este caso, dos vistas.
        m.addObservador(v);
    }
    
}
