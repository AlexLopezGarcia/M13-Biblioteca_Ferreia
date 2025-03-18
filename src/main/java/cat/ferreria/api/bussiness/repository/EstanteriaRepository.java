package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.Estanteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Estanteria.
 *
 * @author oriol
 * @date 07/02/2025
 */
@Repository
public interface EstanteriaRepository extends JpaRepository<Estanteria, Long> {

}
