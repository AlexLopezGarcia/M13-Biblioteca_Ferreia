package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {
    List<Libro> findByAutor(String autor);
    List<Libro> findByCategoria(String categoria);

    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:keyword%")
    List<Libro> findByTitleContaining(@Param("keyword") String keyword);
}