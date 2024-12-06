package clienteHandler;

import entidades.Partida;
import java.io.*;
import java.net.*;
import servidor.GameServer;

public class ClienteHandler implements Runnable {

    private Socket socket;
    private GameServer server;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClienteHandler(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object mensaje = in.readObject(); // No es necesario sincronizar esta línea
                server.manejarMensaje(mensaje, this); // Procesar el mensaje en el servidor
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            server.desconectarCliente(this); // Manejar la desconexión del cliente
        }
    }

    // Enviar un mensaje al cliente
    public synchronized void enviarMensajeCliente(Object mensaje) {
        try {
            System.out.println("Cliente handler envia info al hilo del cliente");
            Partida nuevaPartida = (Partida) mensaje;
            System.out.println("Size jugadores enviados"+ nuevaPartida.getJugadores().size());
            out.writeObject(nuevaPartida);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
