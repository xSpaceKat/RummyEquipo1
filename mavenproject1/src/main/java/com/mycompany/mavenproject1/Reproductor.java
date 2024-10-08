/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author Cyber Centro 08
 */
import java.util.Scanner;
import java.util.List;

public class Reproductor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Blackboard blackboard = new Blackboard();
        
        // Añadir canciones predeterminadas
        blackboard.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", "Rock", 5));
        blackboard.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", "Pop", 4));
        blackboard.agregarCancion(new Cancion("Blinding Lights", "The Weeknd", "Synthwave", 5));
        blackboard.agregarCancion(new Cancion("Hotel California", "Eagles", "Rock", 5));

        Genero filtroPorGenero = new Genero();
        Artista filtroPorArtista = new Artista();
        Calificacion filtroPorCalificacion = new Calificacion();
        Historial historial = new Historial(blackboard.getHistorial());

        int opcion;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Anadir cancion");
            System.out.println("2. Reproducir cancion");
            System.out.println("3. Filtrado");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    // Añadir canción
                    System.out.print("Nombre de la cancion: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Genero: ");
                    String genero = scanner.nextLine();
                    System.out.print("Calificacion (1-5): ");
                    int calificacion = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea

                    Cancion nuevaCancion = new Cancion(nombre, artista, genero, calificacion);
                    blackboard.agregarCancion(nuevaCancion);
                    System.out.println("Cancion anadida con exito.");
                    break;

                case 2:
                    // Mostrar la lista de canciones y luego reproducir la seleccionada
                    blackboard.mostrarCanciones();
                    if (!blackboard.getCanciones().isEmpty()) {
                        System.out.print("Introduce el indice de la cancion a reproducir: ");
                        int indice = scanner.nextInt();
                        blackboard.reproducirCancion(indice);
                    }
                    break;

                case 3:
                    // Mostrar recomendaciones con filtros
                    System.out.println("Recomendaciones por:");
                    System.out.println("1. Genero");
                    System.out.println("2. Ultimas canciones reproducidas");
                    System.out.println("3. Artista");
                    System.out.println("4. Calificacion");
                    System.out.print("Elige una opcion: ");
                    int filtroOpcion = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea

                    switch (filtroOpcion) {
                        case 1:
                            System.out.print("Ingresa el genero: ");
                            String generoFiltro = scanner.nextLine();
                            List<Cancion> cancionesPorGenero = filtroPorGenero.filtrarPorGenero(blackboard.getCanciones(), generoFiltro);
                            mostrarResultados(cancionesPorGenero);
                            break;

                        case 2:
                            historial.mostrarHistorial();
                            break;

                        case 3:
                            System.out.print("Ingresa el nombre del artista: ");
                            String artistaFiltro = scanner.nextLine();
                            List<Cancion> cancionesPorArtista = filtroPorArtista.filtrarPorArtista(blackboard.getCanciones(), artistaFiltro);
                            mostrarResultados(cancionesPorArtista);
                            break;

                        case 4:
                            System.out.print("Ingresa la calificación mínima (1-5): ");
                            int calificacionFiltro = scanner.nextInt();
                            List<Cancion> cancionesPorCalificacion = filtroPorCalificacion.filtrarPorCalificacion(blackboard.getCanciones(), calificacionFiltro);
                            mostrarResultados(cancionesPorCalificacion);
                            break;

                        default:
                            System.out.println("Opcion no valida.");
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    public static void mostrarResultados(List<Cancion> canciones) {
        if (canciones.isEmpty()) {
            System.out.println("No se encontraron canciones.");
        } else {
            System.out.println("Recomendaciones:");
            for (Cancion cancion : canciones) {
                System.out.println(cancion);
            }
        }
    }
}
