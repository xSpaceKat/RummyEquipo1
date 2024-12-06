package entidades;

import java.awt.Color;

import java.io.Serializable;

/**
 *
 * @author galan
 */
public class Grupo implements Serializable{
    private Color color;
    private int numeroGrupo;

    public Grupo() {
    }

    public Grupo(Color color, int numeroGrupo) {
        this.color = color;
        this.numeroGrupo = numeroGrupo;
    }

    public Grupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumeroGrupo() {
        return numeroGrupo;
    }

    public void setNumeroGrupo(int numeroGrupo) {
        this.numeroGrupo = numeroGrupo;
    }
    
}
