package com.ferreria.biblioteca.business.models;

import jakarta.persistence.*;
import java.util.*;

/**
 * @author Ferreria
 */
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "codigo_barras", nullable = false, unique = true)
    private String codigoBarras;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "autor")
    private String autor;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @Column(name = "estado_uso")
    private String estadoUso;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Estante> estantes;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String codigoBarras, String editorial, String autor, String categoria, int cantidad, String estadoUso) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.codigoBarras = codigoBarras;
        this.editorial = editorial;
        this.autor = autor;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.estadoUso = estadoUso;
    }

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

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstadoUso() {
        return estadoUso;
    }

    public void setEstadoUso(String estadoUso) {
        this.estadoUso = estadoUso;
    }

    public List<Estante> getEstantes() {
        return estantes;
    }

    public void setEstantes(List<Estante> estantes) {
        this.estantes = estantes;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", codigoBarras=" + codigoBarras + ", editorial=" + editorial + ", autor=" + autor + ", categoria=" + categoria + ", cantidad=" + cantidad + ", estadoUso=" + estadoUso + '}';
    }

}
