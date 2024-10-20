/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 * Interfaz obserbable. Esta interfaz se implementara a toda clase que quiera ser observable y notificar a observadores de lo que ocurra internamente en su clase.
 * @author galan
 */
public interface Observable <T>{
    /**
     * Añade observadores a nuestro observable
     * @param t : Observador a añadir. Es un genérico y acepta cualquier tipo de clase/interfaz.
     */
    public void addObservador(T t);
    
    /**
     * Borra observadores de nuestro observable
     * @param t : Observador a eliminar. Es un generico y acepta cualquier tipo de clase/interfaz.
     */
    public void removeObservador(T t);
    
    
}
