/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.List;

/**
 *
 * @author galan
 */
public class Jugador {
    private String nombre;
    private String avatar;
    private List<Grupo> coloresGrupo;
    private List<Ficha> fichas;
    private boolean preparado;
    private int turno;

    // Constructor
    public Jugador(String nombre, String avatar, List<Grupo> coloresGrupo, List<Ficha> fichas, boolean preparado, int turno) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.coloresGrupo = coloresGrupo;
        this.fichas = fichas;
        this.preparado = preparado;
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Grupo> getColoresGrupo() {
        return coloresGrupo;
    }

    public void setColoresGrupo(List<Grupo> coloresGrupo) {
        this.coloresGrupo = coloresGrupo;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public boolean isPreparado() {
        return preparado;
    }

    public void setPreparado(boolean preparado) {
        this.preparado = preparado;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    
}