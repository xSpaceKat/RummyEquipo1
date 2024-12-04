/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebas;

/**
 *
 * @author galan
 */
import java.util.List;

public class Pruebas {
    private int counter; // Contador actual
    private final int size; // Tamaño máximo

    // Constructor
    public Pruebas(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor que 0");
        }
        this.size = size;
        this.counter = 0; // Inicia en 0
    }

    // Método para obtener el siguiente número cíclico
    public int next() {
        counter = (counter % size) + 1; // Incrementa y reinicia cuando alcanza el tamaño
        return counter;
    }

    public static void main(String[] args) {
        // Crear una lista de ejemplo
        List<String> items = List.of("A", "B", "C", "D");

        // Crear una instancia del contador
        Pruebas cyclicCounter = new Pruebas(items.size());

        // Simular llamadas al método next()
        for (int i = 0; i < 10; i++) { // Ejemplo con 10 llamadas
            int currentCount = cyclicCounter.next();
            System.out.println("Contador: " + currentCount + " -> Elemento: " + items.get(currentCount - 1));
        }
    }
}

