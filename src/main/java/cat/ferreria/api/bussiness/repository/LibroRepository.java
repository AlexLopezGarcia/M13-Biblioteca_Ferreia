package cat.ferreria.api.bussiness.repository;

import cat.ferreria.api.bussiness.model.clazz.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repositorio de libros que extiende JpaRepository para operaciones CRUD.
 *
 * @author alexl
 * @date 14/02/2025
 * */

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIsbn(String isbn);
    List<Libro> findByTitulo(String titulo);
    List<Libro> findByAutor(String autor);
    List<Libro> findByCategoria(String categoria);

    //Cantidad Libro
    @Query("SELECT COUNT(l) FROM Libro l WHERE l.titulo = :nombre")
    int countByName(@Param("nombre") String nombre);

    @Query("SELECT l FROM Libro l WHERE l.autor LIKE %:keyword%")
    List<Libro> findByAutorContaining(@Param("keyword") String keyword);

    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:keyword%")
    List<Libro> findByTitleContaining(@Param("keyword") String keyword);

    @Query("SELECT l FROM Libro l WHERE l.estadoUso = true")
    List<Libro> findByEstadoUso();

    @Query("SELECT l FROM Libro l JOIN Historial h ON l.libroId = h.libro.libroId WHERE h.fechaDevolucion = :fecha")
    List<Libro> findByFechaDevolucion(@Param("fecha") LocalDateTime fecha);

    @Query("SELECT l FROM Libro l JOIN Historial h ON l.libroId = h.libro.libroId WHERE h.fechaPrestamo = :fecha")
    List<Libro> findByFechaPrestamo(@Param("fecha") LocalDateTime fecha);
}