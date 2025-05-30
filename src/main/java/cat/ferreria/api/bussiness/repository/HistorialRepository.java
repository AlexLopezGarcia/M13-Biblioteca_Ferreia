package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.clazz.Historial;
import cat.ferreria.api.bussiness.model.clazz.Libro;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de entidad Historial
 *
 * @author alexl
 * @date 07/02/2025
 */
@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {
    List<Historial> findByUsuarioDni(String dni);

    @Modifying
    @Transactional
    void deleteByLibroLibroId(Long libroId);
}