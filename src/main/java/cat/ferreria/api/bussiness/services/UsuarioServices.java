package cat.ferreria.api.bussiness.services;
/**
 * @author Ruben
 * @date 07/02/2025
 */
import cat.ferreria.api.bussiness.model.Usuario;
import cat.ferreria.api.bussiness.model.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioServices {

    String create(Usuario usuario);
    Optional<Usuario> read(String dni);
    void update(Usuario usuario);
    void delete(String dni);
    List<UsuarioDTO> getAll();
    String iniciarSesion(String correo, String contrasena);
}
