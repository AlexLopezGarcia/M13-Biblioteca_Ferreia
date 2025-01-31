package com.bibliotecaFerreria.bussiness.model;


public class LibroDTO {
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private Integer cantidad;

    public LibroDTO() {}

    public LibroDTO(String isbn, String titulo, String autor, String categoria, Integer cantidad) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }

    // Getters and Setters (unchanged from previous version)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public static class LibroMapper {
        public static LibroDTO toDTO(Libro libro) {
            return new LibroDTO(
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getCategoria(),
                    libro.getCantidad()
            );
        }
    }
}