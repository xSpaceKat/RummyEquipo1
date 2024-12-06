package pyf.cliente;

import entidades.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    private static Cliente instancia; // Singleton
    private Partida partidaCliente = new Partida(); // Instancia local de la partida
    private final int puerto = 4444;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    private Cliente() {
        try {
            socket = new Socket("localhost", puerto);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            // Hilo para recibir mensajes del servidor
            new Thread(this::recibirSerializado).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Cliente getInstancia() {
        if (instancia == null) {
            instancia = new Cliente();
        }
        return instancia;
    }

    // Escuchar mensajes del servidor
    private void recibirSerializado() {
        try {
            while (true) {
                Object mensaje = in.readObject(); // No es necesario sincronizar esta línea
                if (mensaje instanceof Partida) {
                    Partida partidaRecibida = (Partida) mensaje;
                    System.out.println("La partida recibida tiene jugadores" + partidaRecibida.getJugadores().size());
                    actualizarPartidaLocal(partidaRecibida);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Actualizar la partida local
    private synchronized void actualizarPartidaLocal(Partida nuevaPartida) {
        if (nuevaPartida == null) {
            System.err.println("La partida recibida es nula.");
            return;
        }

        partidaCliente.actualizarInstancia(nuevaPartida);
        System.out.println("Partida actualizada de cliente local: " + partidaCliente.getJugadores().size() + " jugadores.");
    }

    // Enviar actualizaciones al servidor
    public synchronized void enviarSerializado(Object mensaje) {
        try {
            Partida partidaRecibida = (Partida) mensaje;
            System.out.println("La partida enviada tiene jugadores" + partidaRecibida.getJugadores().size());
            out.writeObject(mensaje);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Partida getPartidaCliente() {
        return partidaCliente;
    }
}
