/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.cliente;

import entidades.Jugador;
import entidades.Partida;
import servidor.GameServer;

/**
 *
 * @author galan
 */
public class Pruebas {
    public static void main(String[] args) {
        // Iniciar el servidor en un hilo separado
        new Thread(() -> {
            new GameServer();
        }).start();

        // Esperar un momento para asegurar que el servidor está listo
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Conectar varios clientes al servidor
        Cliente cliente1 = new Cliente("localhost", 4444);
        Cliente cliente2 = new Cliente("localhost", 4444);
        Cliente cliente3 = new Cliente("localhost", 4444);
        Cliente cliente4 = new Cliente("localhost", 4444);

        // Enviar mensajes desde los clientes
        try {
            Thread.sleep(1000);  // Esperar a que las conexiones se establezcan

            Partida partida= new Partida();
            // Cliente 1 envía un mensaje
            System.out.println("Cliente 1 envía un jugador.");
            Jugador jugador= new Jugador();
            partida.unirJugador(jugador);
            jugador.setNombre("xd");
            cliente1.enviarSerializado(partida);
            System.out.println(cliente1.getPartidaCliente().getJugadores().size());

            // Cliente 2 envía un mensaje
            System.out.println("Cliente 2 envía un jugador.");
            Jugador jugador2= new Jugador();
            jugador.setNombre("xd 2");
            partida.unirJugador(jugador2);
            cliente2.enviarSerializado(partida);
            System.out.println(cliente1.getPartidaCliente().getJugadores().size());

            // Cliente 3 envía un mensaje
            System.out.println("Cliente 3 envía un jugador.");
            Jugador jugador3= new Jugador();
            jugador.setNombre("xd 3");
            partida.unirJugador(jugador3);
            cliente3.enviarSerializado(partida);
            System.out.println(cliente1.getPartidaCliente().getJugadores().size());
            
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
