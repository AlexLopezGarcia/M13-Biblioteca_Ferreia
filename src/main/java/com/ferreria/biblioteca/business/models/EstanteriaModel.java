package com.ferreria.biblioteca.business.models;

import jakarta.persistence.*;
import java.util.*;

/**
 * @author Ferreria
 */
@Entity
@Table(name = "estanterias")
public class EstanteriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int estanteriaID;
    @Column
    private String nombre;
    @OneToOne
    @JoinColumn(name = "estanteID")
    private Estante estante;

    public EstanteriaModel() {
    }

    public int getEstanteriaID() {
        return estanteriaID;
    }

    public void setEstanteriaID(int estanteriaID) {
        this.estanteriaID = estanteriaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estante getEstante() {
        return estante;
    }

    public void setEstante(Estante estante) {
        this.estante = estante;
    }

    @Override
    public String toString() {
        return "Estanteria{" + "estanteriaID=" + estanteriaID + ", nombre=" + nombre + ", estante=" + estante + '}';
    }

   


}
