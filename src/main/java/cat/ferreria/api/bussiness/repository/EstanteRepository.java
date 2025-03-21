package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.clazz.Estante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author alexl
 * @date 14/03/2025
 */
@Repository
public interface EstanteRepository extends JpaRepository<Estante, Long> {
    List<Estante> findByLibroIsbn(String isbn);
    List<Estante> findByEstanteriaEstanteriaId(Long estanteriaId);

    @Query("SELECT e FROM Estante e WHERE e.libro.titulo LIKE %:keyword%")
    List<Estante> findByTitleContaining(@Param("keyword") String keyword);
}