package cat.ferreria.api.bussiness.repository;
/**
 * @author Ruben
 * @date 07/02/2025
 */
import cat.ferreria.api.bussiness.model.Usuario;
import cat.ferreria.api.bussiness.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Repository
public interface UsuarioRepositori extends JpaRepository<Usuario, String> {
}
