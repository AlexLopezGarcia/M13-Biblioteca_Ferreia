package cat.ferreria.api.configs.security;

import cat.ferreria.api.bussiness.model.clazz.Usuario;
import cat.ferreria.api.bussiness.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findById(dni)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con DNI: " + dni));

        return new User(usuario.getDni(), usuario.getContrasenya(), new ArrayList<>());
    }
}