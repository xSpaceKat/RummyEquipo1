package entidades;

import java.io.Serializable;

/**
 *
 * @author galan
 */
public class FichaNormal extends Ficha implements Serializable{
    private int valor;
    private Grupo grupo;

    public FichaNormal() {
    }

    public FichaNormal(int valor, Grupo grupo) {
        this.valor = valor;
        this.grupo = grupo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    
    
    
}
