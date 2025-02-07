package com.bibliotecaFerreria.presentation.restcontrollers;
/**
 * @author Ruben
 * @date 07/02/2025
 */
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.bibliotecaFerreria.bussiness.model.Usuario;
import com.bibliotecaFerreria.bussiness.model.UsuarioDTO;
import com.bibliotecaFerreria.backend.config.ErrorResponse;
import com.bibliotecaFerreria.bussiness.services.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    // CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario usuario) {
        String dni;

        try {
            dni = usuarioServices.create(usuario);
            URI uri = UriComponentsBuilder.fromPath("/usuarios/{dni}").buildAndExpand(dni).toUri();
            return ResponseEntity.created(uri).build();
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Error al crear el usuario: " + e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    // READ
    @GetMapping("/{dni}")
    public ResponseEntity<?> read(@PathVariable("dni") String dni) {
        Optional<Usuario> optional = usuarioServices.read(dni);

        if (optional.isEmpty()) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "No se encuentra el usuario con DNI " + dni);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(optional.get());
    }

    // UPDATE
    @PutMapping("/{dni}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> update(@PathVariable String dni, @RequestBody Usuario usuario) {
        try {
            usuario.setDni(dni);
            usuarioServices.update(usuario);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "No se encuentra el usuario con DNI " + dni + ". No se ha podido actualizar.");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    // DELETE
    @DeleteMapping("/{dni}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable String dni) {
        try {
            usuarioServices.delete(dni);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "No se encuentra el usuario con DNI [" + dni + "]. No se ha podido eliminar.");
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> usuarios = usuarioServices.getAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}

