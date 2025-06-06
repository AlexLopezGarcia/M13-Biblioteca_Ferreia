package cat.ferreria.api.bussiness.repository;

/**
 * Repositorio para la entidad Usuario.
 *
 * @author Ruben
 * @date 18/02/2025
 */
import cat.ferreria.api.bussiness.model.clazz.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
