package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.Estante;
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
public interface EstanteRepository extends JpaRepository<Estante, Integer>{
    List<Estante> findByEstante(String estante);
    List<Estante> findByEstanteria(String estanteria);

    @Query("SELECT l FROM Estante l WHERE l.libro.titulo LIKE %:keyword%")
    List<Estante> findByTitleContaining(@Param("keyword") String keyword);
}
