package mvc.modelos;

import entidades.Jugador;
import mvc.cambioFrames.CambioFrameCrearPartida;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import mvc.dto.MazoDTO;
import pyf.cliente.Cliente;
import pyf.pipebuilders.PipelineCrearPartida;

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
    private boolean partidaCreada = false;


    /**
     * Constructora del modelo. Crea un modelo, inicializa variables. Crea la
     * lista de los observadores.
     */
    public ModeloCrearPartida() {
        //Inicializamos atributos...
        observadores = new ArrayList<ModeloObserver>();
        rangoFichas = 13;
        comodines = 2;
    }

    /**
     *
     */
    public void mostrarMenu() {
        notificarObservadoresCambioVentana(ConstantesVentanas.JMENU);
    }

    public void crearPartida() {
        if (partidaCreada) {
            System.out.println("La partida ya fue creada para este cliente.");
            return;
        }
        partidaCreada = true;
        
        String[] SUSTANTIVOS = {
            "Lobo", "Águila", "Tigre", "León", "Halcón", "Dragón", "Pantera", "Fénix"};
        String[] ADJETIVOS = {
            "Rápido", "Fuerte", "Valiente", "Ingenioso", "Astuto", "Ágil", "Sereno", "Sabio"
        };
        Random random = new Random();
        String adjetivo = ADJETIVOS[random.nextInt(ADJETIVOS.length)];
        String sustantivo = SUSTANTIVOS[random.nextInt(SUSTANTIVOS.length)];
        int numero = random.nextInt(1000); // Número al azar para evitar duplicados
        String nombre= adjetivo + sustantivo + numero;

        PipelineCrearPartida pipelineCrearPartida = new PipelineCrearPartida();
        Jugador jugador = new Jugador(nombre, "");
        MazoDTO mazoDTO = new MazoDTO(rangoFichas, comodines, jugador);
        Cliente cliente = Cliente.getInstancia();
        cliente.enviarSerializado(pipelineCrearPartida.ejecutar(mazoDTO));

        System.out.println("Número de jugadores en partida local: " + cliente.getPartidaCliente().getJugadores().size());
        notificarObservadoresCambioVentana(ConstantesVentanas.JLOBBYPARTY);
    }

    /**
     * Funcion sumar. Incrementa el valor del rango de fichas.
     */
    public void sumarRangoFichas() {
        if (rangoFichas < 10) {

        } else if (rangoFichas > 13) {

        } else {
            rangoFichas++;
        }
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
            frame = new CambioFrameCrearPartida(rangoFichas, comodines);
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
