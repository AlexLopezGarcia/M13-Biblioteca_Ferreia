package com.ferreria.biblioteca.business.models;

import jakarta.persistence.*;

/**
 * @author Ferreria
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @Column(name = "dni", nullable = false, unique = true)
    private String dni;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String contrasena, String correoElectronico) {
        this.dni = dni;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
    }

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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", nombre=" + nombre + ", contrasena=" + contrasena + ", correoElectronico=" + correoElectronico + '}';
    }

}
