package cat.ferreria.api.bussiness.model.dtos;

import cat.ferreria.api.bussiness.model.clazz.Usuario;
import lombok.*;

/**
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
    private String correoElectronico;

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
