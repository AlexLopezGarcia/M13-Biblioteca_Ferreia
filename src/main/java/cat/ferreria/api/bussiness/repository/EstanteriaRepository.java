package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.clazz.Estante;
import cat.ferreria.api.bussiness.model.clazz.Estanteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Estanteria.
 *
 * @author oriol
 * @date 07/02/2025
 */
@Repository
public interface EstanteriaRepository extends JpaRepository<Estanteria, Long> {

    // Busca estanterías cuyo nombre contenga la cadena dada, ignorando mayúsculas/minúsculas
    List<Estanteria> findByNombreContainingIgnoreCase(String nombre);
    List<Estante> findEstanteByEstanteriaId(Long estanteriaId);

}
