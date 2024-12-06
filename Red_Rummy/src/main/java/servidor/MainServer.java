/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

/**
 *
 * @author galan
 */
public class MainServer {
    public static void main(String[] args) {
        GameServer server = new GameServer();
        Thread serverThread = new Thread((Runnable) server);
        serverThread.start(); // Ejecuta el servidor en un hilo independiente
    }
}

