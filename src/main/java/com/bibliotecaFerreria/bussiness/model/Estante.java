package com.bibliotecaFerreria.bussiness.model;

import jakarta.persistence.*;

/**
 * @author alexh
 */
@Entity
@Table(name = "estante")
public class Estante {

    @Id
    @Column(name = "estante_id", nullable = false)
    private int estanteID;

    @ManyToOne
    @JoinColumn(name = "isbn", nullable = false)
    private Libro libro;

    public Estante() {
    }

    public Estante(int estanteID, Libro libro) {
        this.estanteID = estanteID;
        this.libro = libro;
    }

    public int getEstanteID() {
        return estanteID;
    }

    public void setEstanteID(int estanteID) {
        this.estanteID = estanteID;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Estante{" + "estante_id=" + estanteID + ", libro=" + libro + '}';
    }

}
