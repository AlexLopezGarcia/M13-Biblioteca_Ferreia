package com.bibliotecaFerreria.bussiness.model;

public class EstanteriaDTO {

    private Integer estanteriaID;
    private String nombre;

    public EstanteriaDTO() {}

    public EstanteriaDTO(Integer estanteriaID, String nombre) {
        this.estanteriaID = estanteriaID;
        this.nombre = nombre;
    }

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

    public static class EstanteriaMapper {
        public static EstanteriaDTO toDTO(Estanteria estanteria) {
            return new EstanteriaDTO(
                    estanteria.getEstanteriaID(),
                    estanteria.getNombre()
            );
        }
    }
}
