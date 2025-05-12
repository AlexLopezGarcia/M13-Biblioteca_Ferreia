package cat.ferreria.api.bussiness.services.impls;

import cat.ferreria.api.bussiness.model.clazz.*;
import cat.ferreria.api.bussiness.repository.*;
import cat.ferreria.api.bussiness.services.interfaces.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicesImpl implements LibroServices {
    private final LibroRepository libroRepository;
    private final HistorialRepository historialRepository;

    @Autowired
    public LibroServicesImpl(LibroRepository libroRepository,
                             HistorialRepository historialRepository) {
        this.libroRepository     = libroRepository;
        this.historialRepository = historialRepository;
    }

    @Override
    public List<Libro> getAll() {
        return libroRepository.findAll();
    }

    public Optional<Libro> read(Long libroId) {
        return libroRepository.findById(libroId);
    }

    public Optional<Libro> readByIsbn(String isbn) {
        return libroRepository.findByIsbn(isbn).stream().findFirst();
    }

    public String create(Libro libro) {
        libroRepository.save(libro);
        return libro.getIsbn();
    }

    @Override
    public Optional<Libro> read(long libro_id) {
        return Optional.empty();
    }

    public void update(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    @Transactional
    public void delete(long libroId, boolean force) {
        if (force) {
            // Elimina primero los historiales asociados al libro
            historialRepository.deleteByLibroLibroId(libroId);
        }
        libroRepository.deleteById(libroId);
    }
}