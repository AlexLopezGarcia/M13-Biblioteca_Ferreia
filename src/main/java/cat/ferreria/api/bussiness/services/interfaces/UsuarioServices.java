package cat.ferreria.api.bussiness.services.interfaces;

import cat.ferreria.api.bussiness.model.clazz.Usuario;
import cat.ferreria.api.bussiness.model.dtos.UsuarioDTO;

import java.util.List;
import java.util.Optional;

/**
 * Interzfaz de servicios para la gestión de usuarios.
 *
 * @author Ruben
 * @date 07/02/2025
 */

public interface UsuarioServices {

    String create(Usuario usuario);
    Optional<Usuario> read(String dni);
    void update(Usuario usuario);
    void delete(String dni);
    List<UsuarioDTO> getAll();
}
