/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import clienteHandler.ClienteHandler;
import entidades.Jugador;
import entidades.Partida;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author galan
 */
public class GameServer {

    private ServerSocket serverSocket;
    public List<ClienteHandler> clients = Collections.synchronizedList(new ArrayList<>());
    private Partida partida = new Partida();

    public GameServer() {
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Servidor iniciado en el puerto " + 4444);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                // Verificar si hay espacio para nuevos jugadores
                synchronized (clients) {
                    if (clients.size() < 4) {
                        ClienteHandler clientHandler = new ClienteHandler(clientSocket, this);
                        addClientHandler(clientHandler);
                        System.out.println("Cliente aceptado");
                        new Thread(clientHandler).start();
                    } else {
                        // Rechazar conexión
                        System.out.println("No se permite el ingreso de un jugador más. Límite 4");
                        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                        out.close();
                        clientSocket.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Agregar un nuevo cliente a la lista de manejadores
    public synchronized void addClientHandler(ClienteHandler clientHandler) {
        clients.add(clientHandler);
        System.out.println("Cliente conectado. Total clientes: " + clients.size());
    }

    public synchronized void manejarMensaje(Object mensaje, ClienteHandler sender) {
        if (mensaje instanceof Partida) {
            partida = (Partida) mensaje;  // Actualiza el estado de la partida
            enviarMensaje();  // Notifica a todos los clientes
        } else {
            System.out.println("Mensaje recibido no es del tipo esperado (Partida).");
        }
    }

    // Notificar a todos los clientes sobre el estado actualizado
    public void enviarMensaje() {
        synchronized (clients) {
            for (ClienteHandler client : clients) {
                client.enviarMensaje(partida);
            }
        }
    }
}
