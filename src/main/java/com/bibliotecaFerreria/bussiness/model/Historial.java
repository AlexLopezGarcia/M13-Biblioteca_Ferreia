package com.bibliotecaFerreria.bussiness.model;

import jakarta.persistence.*;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "historial")
public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "historial_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historialId;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false)
    private Usuario usuario;

    @Column(name = "isbn", nullable = false, length = 50)
    private String isbn;

    // Constructors
    public Historial() {}

    public Historial(Usuario usuario, String isbn) {
        this.usuario = usuario;
        this.isbn = isbn;
    }

    // Getters and Setters
    public Long getHistorialId() {
        return historialId;
    }

    public void setHistorialId(Long historialId) {
        this.historialId = historialId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}