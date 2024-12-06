package servidor;

import clienteHandler.ClienteHandler;
import entidades.Partida;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameServer {

    private ServerSocket serverSocket;
    public List<ClienteHandler> clients = Collections.synchronizedList(new ArrayList<>());
    private Partida partida = new Partida(); // Instancia única de la partida

    public GameServer() {
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Servidor iniciado en el puerto " + 4444);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                synchronized (clients) {
                    if (clients.size() < 4) { // Limitar a 4 jugadores
                        ClienteHandler clientHandler = new ClienteHandler(clientSocket, this);
                        addClientHandler(clientHandler);
                        new Thread(clientHandler).start();
                        System.out.println("Nuevo cliente conectado. Total: " + clients.size());
                    } else {
                        // Rechazar conexiones adicionales
                        System.out.println("Límite de jugadores alcanzado. Rechazando cliente...");
                        clientSocket.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Añadir un cliente a la lista
    public synchronized void addClientHandler(ClienteHandler clientHandler) {
        clients.add(clientHandler);
        enviarMensajeClientes(); // Enviar el estado actual a todos los clientes
    }

    // Manejar un mensaje recibido desde un cliente
    public synchronized void manejarMensaje(Object mensaje, ClienteHandler sender) {
        if (mensaje instanceof Partida) {
            Partida nuevaPartida = (Partida) mensaje;

            // Actualizar la partida en el servidor
            synchronized (partida) { // Sincronizamos solo la actualización de la partida
                partida.actualizarInstancia(nuevaPartida);
            }
            System.out.println("Partida actualizada por un cliente: Jugadores:" + partida.getJugadores().size());

            // Enviar la actualización a todos los clientes
            enviarMensajeClientes(); 
        } else {
            System.out.println("Mensaje recibido no es del tipo Partida.");
        }
    }

    // Enviar la partida actualizada a todos los clientes
    public synchronized void enviarMensajeClientes() {
        synchronized (clients) {
            for (ClienteHandler client : clients) {
                System.out.println("Cliente " + client.toString() + " envio mensajes");
                client.enviarMensajeCliente(partida);
            }
        }
    }

    // Manejar la desconexión de un cliente
    public synchronized void desconectarCliente(ClienteHandler clientHandler) {
        clients.remove(clientHandler);
        System.out.println("Cliente desconectado. Total clientes: " + clients.size());
        enviarMensajeClientes(); // Notificar a los clientes restantes
    }
}
