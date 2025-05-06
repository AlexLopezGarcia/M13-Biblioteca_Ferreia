package cat.ferreria.api.bussiness.services.impls;

import cat.ferreria.api.bussiness.model.clazz.Libro;
import cat.ferreria.api.bussiness.repository.LibroRepository;
import cat.ferreria.api.bussiness.services.interfaces.LibroServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Service
public class LibroServicesImpl implements LibroServices {
    private final LibroRepository libroRepository;

    @Autowired
    public LibroServicesImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public Optional<Libro> read(long libro_id) {
        return libroRepository.findById(String.valueOf(libro_id));
    }

    @Override
    public String create(Libro libro) {
        return libroRepository.save(libro).getIsbn();
    }

    @Override
    public void update(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public void delete(long libro_id) {
        libroRepository.deleteById(String.valueOf(libro_id));
    }

    @Override
    public List<Libro> getAll() {
        return libroRepository.findAll();
    }
}