package com.grupLibros.bussiness.services;

import com.grupLibros.bussiness.model.Libro;

import java.util.List;
import java.util.Optional;

public interface LibroServices {
    String create(Libro libro);       // C
    Optional<Libro> read(String isbn);  // R
    void update(Libro libro);         // U
    void delete(String isbn);         // D
    List<Libro> getAll();
}