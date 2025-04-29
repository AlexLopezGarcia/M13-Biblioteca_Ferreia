package cat.ferreria.api.configs.security;

import cat.ferreria.api.bussiness.model.clazz.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        Usuario usuario = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.dni = :dni", Usuario.class)
                .setParameter("dni", dni)
                .getSingleResult();

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + dni);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(usuario.getDni())
                .password(usuario.getContrasenya())
                .authorities("USER")
                .build();
    }
}