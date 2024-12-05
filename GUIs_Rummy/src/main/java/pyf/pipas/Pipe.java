/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pyf.pipas;

/**
 *
 * @author Paco
 */
public class Pipe<TIn, TOut> {

    private TIn data; // Dato de entrada
    private IFilter<TIn, TOut> filter; // Filtro conectado a la salida

    // Constructor para inicializar el filtro
    public Pipe(IFilter<TIn, TOut> filter) {
        this.filter = filter;
    }

    // Método para agregar información de entrada
    public void agregarInfo(TIn data) {
        this.data = data;
    }

    // Método para obtener información procesada
    public TOut obtenerInfo() {
        if (filter != null && data != null) {
            return filter.procesar(data);
        } else {
            throw new IllegalStateException("No hay datos o el filtro no está configurado.");
        }
    }

    // Método para enviar los datos procesados
    public void enviar() {
        TOut result = obtenerInfo();
        System.out.println("Enviando datos procesados: " + result);
    }
}
