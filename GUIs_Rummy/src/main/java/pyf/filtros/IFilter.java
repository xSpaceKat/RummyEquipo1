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