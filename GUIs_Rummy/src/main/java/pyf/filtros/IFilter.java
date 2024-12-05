/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pyf.filtros;

/**
 *
 * @author Paco
 */
public interface IFilter<TIn, TOut> {
    void procesar(TIn input, Pipe<TOut> outputPipe);
}
