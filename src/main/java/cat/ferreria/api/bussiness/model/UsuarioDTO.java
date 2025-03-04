package cat.ferreria.api.bussiness.model;

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
