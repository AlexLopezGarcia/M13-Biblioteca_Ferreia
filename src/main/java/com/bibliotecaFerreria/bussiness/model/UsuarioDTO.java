package com.bibliotecaFerreria.bussiness.model;
/**
 * @author Ruben
 * @date 18/02/2025
 */
public class UsuarioDTO {
    private String dni;
    private String nombre;
    private String correoElectronico;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String dni, String nombre, String correoElectronico) {
        this.dni = dni;
        this.nombre = nombre;
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
    public static class UsuarioMapper {
        public static UsuarioDTO toDTO(Usuario usuario) {
            return new UsuarioDTO(
                    usuario.getDni(),
                    usuario.getNombre(),
                    usuario.getCorreoElectronico()
            );
        }
    }

}
