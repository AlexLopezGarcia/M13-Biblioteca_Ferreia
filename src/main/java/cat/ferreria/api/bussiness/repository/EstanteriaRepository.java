package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.Estanteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstanteriaRepository extends JpaRepository<Estanteria, Integer> {

    List<Estanteria> findByNombre(String nombre);

    @Query("SELECT e FROM Estanteria e WHERE e.nombre LIKE %:keyword%")
    List<Estanteria> findByNombreContaining(@Param("keyword") String keyword);
}
