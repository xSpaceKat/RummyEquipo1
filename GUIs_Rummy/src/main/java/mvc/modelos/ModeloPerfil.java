package mvc.modelos;

import java.awt.Color;
import java.util.ArrayList;
import pyf.pipebuilders.PipelineConsultarSeleccionColores;
import entidades.Jugador;
import fachada.PerfilFachada;
import pyf.pipebuilders.PipelineConsultarSeleccionNombre;

/**
 * Modelo de mi programa, aquí estará toda la lógica y el funcionamiento interno
 * de este. Lo hacemos Observable sobre los observadores del modelo, para que
 * sean notificados con lo que les interese.
 *
 * @author galan
 */
public class ModeloPerfil implements Observable<ModeloObserver> {

    //Aquí añadiremos la liste de nuestros observadores
    private ArrayList<ModeloObserver> observadores;
    PipelineConsultarSeleccionColores colorsito = new PipelineConsultarSeleccionColores();
    Jugador jugador = new Jugador();
    PerfilFachada perfilFachada = new PerfilFachada(jugador);
    PipelineConsultarSeleccionNombre pipelineConsultarSeleccion = new PipelineConsultarSeleccionNombre();

    /**
     * Constructora del modelo. Crea un modelo, inicializa variables. Crea la
     * lista de los observadores.
     */
    public ModeloPerfil() {
        //Inicializamos atributos...
        observadores = new ArrayList<ModeloObserver>();
        colorsito.getInstancia();
    }

    /**
     * Funcion sumar. Incrementa el valor.
     */
    public void mostrarUnirsePartida() {
        notificarObservadoresCambioVentana(ConstantesVentanas.JUNIRSEPARTIDA);
    }
    
    public void agregarColores(Color ccolor1, Color ccolor2, Color ccolor3, Color ccolor4){
        colorsito.ejecutar(1, ccolor1);
        colorsito.ejecutar(2, ccolor2);
        colorsito.ejecutar(3, ccolor3);
        colorsito.ejecutar(4, ccolor4);
    }

    public void mostrarLobbyPartida() {
        notificarObservadoresCambioVentana(ConstantesVentanas.JLOBBYPARTY);
    }
    
    public void verfificarSeleccionNombre(String nombre) {
        pipelineConsultarSeleccion.ejecutar(nombre);
    }
    
    public void cambiarNombre(String nombre) {
        perfilFachada.cambiarNombre(nombre);
    }
    
    public void cambiarAvatar(String avatar) {
        perfilFachada.cambiarFoto(avatar);
    }
    
    public void cambiarColores(int numGrupo, Color color) {
        perfilFachada.cambiarColoresFichas(numGrupo, color);
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
