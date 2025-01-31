package com.bibliotecaFerreria.bussiness.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dni")
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String contrasenya;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Historial> historial;

    // Constructors
    public Usuario() {}

    public Usuario(String dni, String nombre, String contrasenya, String correoElectronico) {
        this.dni = dni;
        this.nombre = nombre;
        this.contrasenya = contrasenya;
        this.correoElectronico = correoElectronico;
    }

    // Getters and Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }
}