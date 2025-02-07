package com.bibliotecaFerreria.bussiness.services;

import com.bibliotecaFerreria.bussiness.model.Libro;
import com.bibliotecaFerreria.bussiness.repository.LibroRepository;
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
    public Optional<Libro> read(String isbn) {
        return libroRepository.findById(isbn);
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
    public void delete(String isbn) {
        libroRepository.deleteById(isbn);
    }

    @Override
    public List<Libro> getAll() {
        return libroRepository.findAll();
    }
}