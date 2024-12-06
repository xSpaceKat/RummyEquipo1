package mvc.modelos;

import entidades.Ficha;
import entidades.Partida;
import fachada.JuegoFachada;
import iFachada.IJuegoFachada;
import java.util.ArrayList;
import java.util.List;
import pyf.cliente.Cliente;
import pyf.pipebuilders.PipelineContadorFicha;
import pyf.pipebuilders.PipelineJalarFicha;

/**
 * Modelo de mi programa, aquí estará toda la lógica y el funcionamiento interno
 * de este. Lo hacemos Observable sobre los observadores del modelo, para que
 * sean notificados con lo que les interese.
 *
 * @author galan
 */
public class ModeloTablero implements Observable<ModeloObserver> {

    //Aquí añadiremos la liste de nuestros observadores
    private ArrayList<ModeloObserver> observadores;
    //Añadan las pipelines aquí
    PipelineJalarFicha pipelineJF;
    PipelineContadorFicha pipelineCF;

    /**
     * Constructora del modelo. Crea un modelo, inicializa variables. Crea la
     * lista de los observadores.
     */
    public ModeloTablero() {
        // Inicializamos los atributos.
        observadores = new ArrayList<>();
        try {
            pipelineJF = PipelineJalarFicha.getInstancia();
//            pipelineCF = PipelineContadorFicha.getInstance();
        } catch (Exception e) {
            System.err.println("Error al inicializar pipelines: " + e.getMessage());
        }
    }

    /**
     * Funcion sumar. Incrementa el valor.
     */
    public void mostrarResultados() {
        notificarObservadoresCambioVentana(ConstantesVentanas.JRESULTADOS);
    }

    public void jalarFicha() {
        Partida partidaActual = Partida.obtenerInstancia();
        Cliente cliente = Cliente.getInstancia();
        cliente.enviarSerializado(pipelineJF.ejecutar(partidaActual));
        this.notificarObservadores();
    }

    public void verificarCantidadFicha() {
        try {
            Partida partidaActual = Partida.obtenerInstancia();
            Cliente cliente = Cliente.getInstancia();
            cliente.enviarSerializado(pipelineCF.ejecutar(partidaActual));
            this.notificarObservadores();
            this.notificarObservadoresCambioVentana(0);
        } catch (Exception e) {
            System.err.println("Error al verificar la cantidad de fichas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public List<Ficha> manoJugador(String nombreJugador){
        Partida partidaActual = Partida.obtenerInstancia();
        IJuegoFachada jf = new JuegoFachada(partidaActual);
        return jf.obtenerFichasJugador(nombreJugador);
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
