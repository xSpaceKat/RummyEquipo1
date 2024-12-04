/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.modelos;

import java.util.ArrayList;

/**
 *
 * @author OMEN
 */
public class ModeloLobbyPartida implements Observable<ModeloObserver>{
    //Aquí añadiremos la liste de nuestros observadores
    private ArrayList<ModeloObserver> observadores;

    /**
     * Constructora del modelo. Crea un modelo, inicializa variables. Crea la
     * lista de los observadores.
     */
    public ModeloLobbyPartida() {
        //Inicializamos atributos...
        observadores = new ArrayList<ModeloObserver>();
    }
    
    public void mostrarCrearPartida() {
        notificarObservadoresCambioVentana(ConstantesVentanas.JCREARPARTIDA);
    }

    public void mostrarPerfil() {
        notificarObservadoresCambioVentana(ConstantesVentanas.JPERFIL);
    }
    
    @Override
    public void addObservador(ModeloObserver t) {
        //Añadimos el observador a nuestro arraylist
        observadores.add(t);
        //Notificamos el valor a nuestros observadores ya que tenemos un nuevo observador que necesita saber el valor.
        notificarObservadores();
    }
    
    @Override
    public void removeObservador(ModeloObserver t) {
        observadores.remove(t);
    }
    
    private void notificarObservadores() {
        //Nos recorremos el arraylist de los observadores
        for (ModeloObserver o : observadores) {
            //Le a cada observador que el valor se ha cambiado al nuevo valor "t".
            //Recuerdo que para este caso, estamos notificando a cada vista que tengamos
            o.update(this, o);
        }
    }
    
    private void notificarObservadoresCambioVentana(int ventana) {
        for (ModeloObserver o : observadores) {
            //Le a cada observador que el valor se ha cambiado al nuevo valor "t".
            //Recuerdo que para este caso, estamos notificando a cada vista que tengamos
            o.cambiarVentana(ventana);
        }
    }

    
}
