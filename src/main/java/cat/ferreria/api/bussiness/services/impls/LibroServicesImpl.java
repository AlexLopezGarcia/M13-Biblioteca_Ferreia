package cat.ferreria.api.bussiness.services.impls;

import cat.ferreria.api.bussiness.model.clazz.Libro;
import cat.ferreria.api.bussiness.repository.LibroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicesImpl {

    @Autowired
    private LibroRepository libroRepository;

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

    public void update(Libro libro) {
        libroRepository.save(libro);
    }

    public void delete(Long libroId) {
        libroRepository.deleteById(libroId);
    }

    public void deleteByIsbn(String isbn) {
        libroRepository.findByIsbn(isbn).stream()
                .findFirst()
                .ifPresent(libro -> libroRepository.deleteById(libro.getLibroId()));
    }

    public int countByName(String nombre) {
        Logger _log = LoggerFactory.getLogger(LibroServicesImpl.class);
        _log.info("Count by name: {}", libroRepository.countByName(nombre));
        return libroRepository.countByName(nombre);
    }
}