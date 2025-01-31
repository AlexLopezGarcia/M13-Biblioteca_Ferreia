package com.grupLibros.presentation.restcontrollers;

import com.grupLibros.bussiness.model.Libro;
import com.grupLibros.bussiness.model.LibroDTO;
import com.grupLibros.bussiness.services.LibroServicesImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/libros")
@Tag(name = "Libros", description = "Gestión de libros")
public class LibroController {
    @Autowired
    private LibroServicesImpl libroServices;

    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAll() {
        List<LibroDTO> libroDTOs = libroServices.getAll().stream()
                .map(LibroDTO.LibroMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(libroDTOs);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<?> read(@PathVariable String isbn) {
        return libroServices.read(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Libro libro) {
        String isbn = libroServices.create(libro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Libro creado con ISBN: " + isbn);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<String> update(@PathVariable String isbn, @RequestBody Libro libro) {
        if (libroServices.read(isbn).isPresent()) {
            libro.setIsbn(isbn);
            libroServices.update(libro);
            return ResponseEntity.ok("Libro actualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Libro no encontrado");
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> delete(@PathVariable String isbn) {
        if (libroServices.read(isbn).isPresent()) {
            libroServices.delete(isbn);
            return ResponseEntity.ok("Libro eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Libro no encontrado");
    }
}