package mvc.modelos;

import mvc.cambioFrames.CambioFrameCrearPartida;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * Modelo de mi programa, aquí estará toda la lógica y el funcionamiento interno
 * de este. Lo hacemos Observable sobre los observadores del modelo, para que
 * sean notificados con lo que les interese.
 *
 * @author galan
 */
public class ModeloCrearPartida implements Observable<ModeloObserver> {

    //Aquí añadiremos la liste de nuestros observadores
    private ArrayList<ModeloObserver> observadores;
    private int rangoFichas, comodines;
    private CambioFrameCrearPartida frame;

    /**
     * Constructora del modelo. Crea un modelo, inicializa variables. Crea la
     * lista de los observadores.
     */
    public ModeloCrearPartida() {
        //Inicializamos atributos...
        observadores = new ArrayList<ModeloObserver>();
        rangoFichas = 0;
        comodines = 0;
    }

    /**
     *
     */
    public void mostrarMenu() {
        notificarObservadoresCambioVentana(ConstantesVentanas.JMENU);
    }
    
    public void mostrarLobbyPartida() {
        notificarObservadoresCambioVentana(ConstantesVentanas.JLOBBYPARTY);
    }

    /**
     * Funcion sumar. Incrementa el valor del rango de fichas.
     */
    public void sumarRangoFichas() {
        rangoFichas++;
        notificarObservadores();
    }

    /**
     * Funcion sumar. Incrementa el valor del rango de fichas.
     */
    public void sumarComodines() {
        comodines++;
        notificarObservadores();
    }

    /**
     * Función restar. Notifica al modelo que quiere decrementar el valor del
     * rango de fichas.
     */
    public void restarRangoFichas() {
        rangoFichas--;
        notificarObservadores();
    }

    /**
     * Función restar. Notifica al modelo que quiere decrementar el valor de los
     * comodines.
     */
    public void restarComodines() {
        comodines--;
        notificarObservadores();
    }

    /**
     * addObservador: Añade observadores a nuestro modelo
     *
     * @param t : observador de tipo ModeloObserver
     */
    @Override
    public void addObservador(ModeloObserver t) {
        //Añadimos el observador a nuestro arraylist
        observadores.add(t);
        //Notificamos el valor a nuestros observadores ya que tenemos un nuevo observador que necesita saber el valor.
        notificarObservadores();
    }

    /**
     * removeObservador: Borra observadores a nuestro modelo
     *
     * @param t : observador que queramos borrar.
     */
    //**En realidad no vamos a emplear en nuestro ejemplo este metodo, pero es importante tenerlo en cuenta.
    @Override
    public void removeObservador(ModeloObserver t) {
        observadores.remove(t);
    }

    /**
     * Método que notifica a nuestros observadores los cambios que nos interese
     * que sepan.
     */
    private void notificarObservadores() {
        //Nos recorremos el arraylist de los observadores
        for (ModeloObserver o : observadores) {
            //Le a cada observador que el valor se ha cambiado al nuevo valor "t".
            //Recuerdo que para este caso, estamos notificando a cada vista que tengamos
            frame= new CambioFrameCrearPartida(rangoFichas, comodines);
            o.update(this, frame);
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
