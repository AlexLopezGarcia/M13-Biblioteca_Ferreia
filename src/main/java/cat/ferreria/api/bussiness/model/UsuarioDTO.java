package cat.ferreria.api.bussiness.model;
/**
 * @author Ruben
 * @date 07/02/2025
 */
public class UsuarioDTO {
    private String dni; // Identificador único
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

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
