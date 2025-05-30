package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.clazz.Libro;
import cat.ferreria.api.bussiness.model.dtos.LibroDTO;
import cat.ferreria.api.bussiness.services.impls.LibroServicesImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de libros.
 * Permite realizar operaciones CRUD sobre los libros.
 *
 * @author alexl
 * @date 16/05/2025
 * */

@RestController
@RequestMapping("/public/libros")
@Tag(name = "Libros", description = "Gestión de libros")
public class LibroController {

    @Autowired
    private LibroServicesImpl libroServices;

    @Operation(
            summary = "Obtener todos los libros",
            description = "Devuelve todos los libros",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Libros encontrados"),
                    @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAll() {
        List<LibroDTO> libroDTOs = libroServices.getAll().stream()
                .map(LibroDTO.LibroMapper::toDTO)
                .toList();
        return ResponseEntity.ok(libroDTOs);
    }

    @Operation(
            summary = "Obtener un libro por ISBN",
            description = "Devuelve un libro por su ISBN",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Libro encontrado"),
                    @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @GetMapping("/{isbn}")
    public ResponseEntity<?> read(@PathVariable String isbn) {
        return libroServices.readByIsbn(isbn)
                .map(LibroDTO.LibroMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("count/{titulo}")
    public int count(@PathVariable String titulo) {
        return libroServices.count(titulo);
    }

    @Operation(
            summary = "Crear un libro",
            description = "Crea un libro",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Libro creado"),
                    @ApiResponse(responseCode = "400", description = "Datos inválidos",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @PostMapping
    public ResponseEntity<LibroDTO> create(@Valid @RequestBody Libro libro) {
        String isbn = libroServices.create(libro);
        return libroServices.readByIsbn(isbn)
                .map(LibroDTO.LibroMapper::toDTO)
                .map(dto -> ResponseEntity.status(HttpStatus.CREATED).body(dto))
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @Operation(
            summary = "Actualizar un libro",
            description = "Actualiza un libro por su ISBN",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Libro actualizado"),
                    @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @PutMapping("/{isbn}")
    public ResponseEntity<LibroDTO> update(@PathVariable String isbn, @Valid @RequestBody Libro libro) {
        if (libroServices.readByIsbn(isbn).isPresent()) {
            libro.setIsbn(isbn);
            libroServices.update(libro);
            return libroServices.readByIsbn(isbn)
                    .map(LibroDTO.LibroMapper::toDTO)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Operation(
            summary = "Eliminar un libro",
            description = "Elimina un libro por su ID",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Libro eliminado"),
                    @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "409", description = "Conflicto: libro asociado a otros registros"),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )

    @DeleteMapping("/{libroId}")
    public ResponseEntity<?> delete(
            @PathVariable Long libroId,
            @RequestParam(name = "force", defaultValue = "false") boolean force) {
        try {
            if (libroServices.read(libroId).isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            libroServices.delete(libroId, force);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}