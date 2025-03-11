package com.bibliotecaFerreria.bussiness.model;

/**
 * @author alexh
 */

public class EstanteDTO {
    private int estanteID;
    private Libro libro;

    public EstanteDTO(){}

    public EstanteDTO(int estanteID, Libro libro) {
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
        return "EstanteDTO{" +
                "estanteID=" + estanteID +
                ", libro=" + libro +
                '}';
    }
}
