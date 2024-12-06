/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pyf.filtros;

import pyf.pipas.Pipe;

/**
 *
 * @author Paco
 */
public interface IFilter<TIn, TOut> {
    // El método ahora devuelve TOut en lugar de void
    TOut procesar(TIn input);
}