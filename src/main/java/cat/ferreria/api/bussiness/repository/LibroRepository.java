package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.clazz.Estante;
import cat.ferreria.api.bussiness.model.clazz.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {
    List<Libro> findByIsbn(String isbn);
    List<Libro> findByTitulo(String titulo);
    List<Libro> findByAutor(String autor);
    List<Libro> findByCategoria(String categoria);

    @Query("SELECT l FROM Libro l WHERE l.autor LIKE %:keyword%")
    List<Libro> findByAutorContaining(@Param("keyword") String keyword);

    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:keyword%")
    List<Libro> findByTitleContaining(@Param("keyword") String keyword);

}