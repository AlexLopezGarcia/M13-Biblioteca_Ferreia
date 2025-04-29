package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.clazz.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/libros")
public class LibroController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public ResponseEntity<List<Libro>> getAllLibros() {
        List<Libro> libros = entityManager.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Libro> getLibroByIsbn(@PathVariable String isbn) {
        try {
            Libro libro = entityManager.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn", Libro.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
            return ResponseEntity.ok(libro);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Libro> createLibro(@RequestBody Libro libro) {
        entityManager.persist(libro);
        return ResponseEntity.status(201).body(libro);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<Libro> updateLibro(@PathVariable String isbn, @RequestBody Libro libro) {
        try {
            Libro existingLibro = entityManager.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn", Libro.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
            existingLibro.setTitulo(libro.getTitulo());
            existingLibro.setAutor(libro.getAutor());
            existingLibro.setCategoria(libro.getCategoria());
            existingLibro.setEstadoUso(libro.getEstadoUso());
            entityManager.merge(existingLibro);
            return ResponseEntity.ok(existingLibro);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> deleteLibro(@PathVariable String isbn) {
        try {
            Libro libro = entityManager.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn", Libro.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
            entityManager.remove(libro);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}