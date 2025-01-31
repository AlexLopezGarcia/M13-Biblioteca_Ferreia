package com.grupLibros.bussiness.model;

public class HistorialDTO {
    private Long historialId;
    private String dni;
    private String isbn;

    public HistorialDTO() {}

    public HistorialDTO(Long historialId, String dni, String isbn) {
        this.historialId = historialId;
        this.dni = dni;
        this.isbn = isbn;
    }

    // Getters and Setters
    public Long getHistorialId() {
        return historialId;
    }

    public void setHistorialId(Long historialId) {
        this.historialId = historialId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static class HistorialMapper {
        public static HistorialDTO toDTO(Historial historial) {
            return new HistorialDTO(
                    historial.getHistorialId(),
                    historial.getUsuario().getDni(),
                    historial.getIsbn()
            );
        }
    }
}