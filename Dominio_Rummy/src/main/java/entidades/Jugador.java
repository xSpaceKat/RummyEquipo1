/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author galan
 */
public class Jugador implements Serializable {

    private String nombre;
    private String avatar;
    private List<Grupo> coloresGrupo;
    private List<Ficha> fichas;
    private boolean estado;
    private int turno;

    // Constructor
    public Jugador(String nombre, String avatar) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.coloresGrupo = List.of(
                new Grupo(new Color("#0000FF"), 1), // Azul
                new Grupo(new Color("#FF0000"), 2), // Rojo
                new Grupo(new Color("#00FF00"), 3), // Verde
                new Grupo(new Color("#FFFF00"), 4) // Amarillo
        );
        fichas = new ArrayList<>();
        estado = false;
    }

    public Jugador() {
        // Crear los 4 grupos con colores predefinidos
        this.coloresGrupo = List.of(
                new Grupo(new Color("#0000FF"), 1), // Azul
                new Grupo(new Color("#FF0000"), 2), // Rojo
                new Grupo(new Color("#00FF00"), 3), // Verde
                new Grupo(new Color("#FFFF00"), 4) // Amarillo
        );
        fichas = new ArrayList<>();
        estado = false;
    }

    // Método para cambiar el color de un grupo específico
    public void cambiarColorGrupo(int numeroGrupo, Color nuevoColor) {
        for (Grupo grupo : this.coloresGrupo) {
            if (grupo.getNumeroGrupo() == numeroGrupo) {
                grupo.setColor(nuevoColor);
                System.out.println("Color del grupo " + numeroGrupo + " cambiado a " + nuevoColor.getHexadecimalColor());
                return;
            }
        }
        throw new IllegalArgumentException("El número de grupo " + numeroGrupo + " no existe.");
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Jugador jugador = (Jugador) obj;
        return this.nombre.equals(jugador.nombre); // Supongamos que "nombre" es único
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
