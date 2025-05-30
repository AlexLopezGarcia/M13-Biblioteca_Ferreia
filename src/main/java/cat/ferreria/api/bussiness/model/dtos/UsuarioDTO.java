package cat.ferreria.api.bussiness.model.dtos;

import cat.ferreria.api.bussiness.model.clazz.Usuario;
import lombok.*;

/**
 * DTO para representar un usuario en la API.
 *
 * @author Ruben
 * @date 18/02/2025
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String dni;
    private String nombre;
    private String contrasenya;
    private String correoElectronico;

    public static class UsuarioMapper {
        public static UsuarioDTO toDTO(Usuario usuario) {
            return new UsuarioDTO(
                    usuario.getDni(),
                    usuario.getNombre(),
                    usuario.getContrasenya(),
                    usuario.getCorreoElectronico()
            );
        }
    }

}
