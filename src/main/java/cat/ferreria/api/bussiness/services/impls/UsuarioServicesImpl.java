package cat.ferreria.api.bussiness.services.impls;
/**
 * @author Ruben
 * @date 07/02/2025
 */

import cat.ferreria.api.bussiness.model.clazz.Historial;
import cat.ferreria.api.bussiness.model.clazz.Usuario;
import cat.ferreria.api.bussiness.model.dtos.HistorialDTO;
import cat.ferreria.api.bussiness.model.dtos.UsuarioDTO;
import cat.ferreria.api.bussiness.repository.*;
import cat.ferreria.api.bussiness.services.interfaces.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServicesImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public String create(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getDni())) {
            throw new IllegalStateException("El usuario con DNI " + usuario.getDni() + " ya existe.");
        }

        usuarioRepository.save(usuario);
        return usuario.getDni();
    }

    @Override
    public Optional<Usuario> read(String dni) {
        return usuarioRepository.findById(dni);
    }

    @Override
    public void update(Usuario usuario) {
        if (!usuarioRepository.existsById(usuario.getDni())) {
            throw new IllegalStateException("El usuario con DNI " + usuario.getDni() + " no existe.");
        }

        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(String dni) {
        if (!usuarioRepository.existsById(dni)) {
            throw new IllegalStateException("El usuario con DNI " + dni + " no existe.");
        }

        usuarioRepository.deleteById(dni);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return usuarioRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private UsuarioDTO mapToDTO(Usuario usuario) {

        return new UsuarioDTO(usuario.getDni(), usuario.getNombre(), usuario.getContrasenya() ,usuario.getCorreoElectronico());
    }
}

