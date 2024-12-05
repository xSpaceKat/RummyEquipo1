/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.cliente;

import entidades.Jugador;
import entidades.Partida;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author galan
 */
public class Cliente{
    private Partida partidaCliente= new Partida();
    private int puerto = 4444;
    private Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;
    final String host = "localhost";

    public Cliente(String host, int port) {
        try {
            socket = new Socket(host, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            // Iniciar hilo para recibir mensajes
            new Thread(this::recibirSerializado).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para recibir mensajes del servidor
    public void recibirSerializado() {
        try {
            while (true) {
                Object mensaje = in.readObject();  // Recibe mensaje serializado
                deserializarMensaje(mensaje);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Deserializar el mensaje recibido
    public void deserializarMensaje(Object mensaje) {
        partidaCliente= (Partida) mensaje;
    }

    // Enviar un mensaje serializado al servidor
    public void enviarSerializado(Object mensaje) {
        try {
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
