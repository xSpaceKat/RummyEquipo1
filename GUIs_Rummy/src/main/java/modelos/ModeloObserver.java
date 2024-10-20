/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos;

/**
 * Interfaz Observador. Contendrá los metodos de tipo ModeloObserver para que el observador se actualice 
 * @author galan
 */
public interface ModeloObserver {
    
    public void update(Observable o, Object arg);
    
    public void cambiarVentana(int ventana);

}