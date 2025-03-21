package cat.ferreria.api.bussiness.services;

import cat.ferreria.api.bussiness.model.clazz.Libro;

import java.util.List;
import java.util.Optional;

/**
 * @author alexl
 * @date 07/02/2025
 */
public interface LibroServices {
    String create(Libro libro);       // C
    Optional<Libro> read(String isbn);  // R
    void update(Libro libro);         // U
    void delete(String isbn);         // D
    List<Libro> getAll();
}