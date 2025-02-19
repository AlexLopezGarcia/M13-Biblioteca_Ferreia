package com.ferreria.biblioteca.business.models;

import jakarta.persistence.*;

/**
 * @author Ferreria
 */
@Entity
@Table(name = "historiales")
public class Historial {

    @Id
    @Column(name = "dni", nullable = false)
    private String dni;

    @Column(name = "biblioteca_id", nullable = false)
    private int bibliotecaID;

    @Column(name = "libro", nullable = false)
    private String libro;

    public Historial() {
    }

    public Historial(String dni, int bibliotecaID, String libro) {
        this.dni = dni;
        this.bibliotecaID = bibliotecaID;
        this.libro = libro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getBibliotecaID() {
        return bibliotecaID;
    }

    public void setBibliotecaID(int bibliotecaID) {
        this.bibliotecaID = bibliotecaID;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Historial{" + "dni=" + dni + ", bibliotecaID=" + bibliotecaID + ", libro=" + libro + '}';
    }

}
