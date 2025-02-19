package com.bibliotecaFerreria.bussiness.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estanteria")
public class Estanteria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estanteria_id")
    private Integer estanteriaID;

    @Column(nullable = false)
    private String nombre;


    // Constructores
    public Estanteria() {}

    public Estanteria(Integer estanteriaID, String nombre) {
        this.estanteriaID = estanteriaID;
        this.nombre = nombre;
    }

    // Getters y Setters
    public Integer getEstanteriaID() {
        return estanteriaID;
    }

    public void setEstanteriaID(Integer estanteriaID) {
        this.estanteriaID = estanteriaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estanteria [estanteriaID=" + estanteriaID + ", nombre=" + nombre + "]";
    }
}
