package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.clazz.Libro;
import cat.ferreria.api.bussiness.model.dtos.LibroDTO;
import cat.ferreria.api.bussiness.services.impls.LibroServicesImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alexl
 * @date 07/02/2025
 */
@RestController
@RequestMapping("/libros")
@Tag(name = "Libros", description = "Gestión de libros")
public class LibroController {

    @Autowired
    private LibroServicesImpl libroServices;

    @Operation (
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

    @Operation (
            summary = "Obtener todos los libros",
            description = "Devuelve un libro por su ISBN",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Libro encontrado"),
                    @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @GetMapping("/{libro_id}")
    public ResponseEntity<?> read(@PathVariable long libro_id) {
        return libroServices.read(libro_id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation (
            summary = "Crear un libro",
            description = "Crea un libro",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Libro creado"),
                    @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Libro libro) {
        String isbn = libroServices.create(libro);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Libro creado con ISBN: " + isbn);
    }

    @Operation (
            summary = "Actualizar un libro",
            description = "Actualiza un libro",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Libro actualizado"),
                    @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @PutMapping("/{libro_id}")
    public ResponseEntity<String> update(@PathVariable long libro_id, @RequestBody Libro libro) {
        if (libroServices.read(libro_id).isPresent()) {
            libro.setIsbn(String.valueOf(libro_id));
            libroServices.update(libro);
            return ResponseEntity.ok("Libro actualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Libro no encontrado");
    }

    @Operation (
            summary = "Eliminar un libro",
            description = "Elimina un libro",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Libro eliminado"),
                    @ApiResponse(responseCode = "404", description = "Libro no encontrado",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )

    @DeleteMapping("/{libro_id}")
    public ResponseEntity<?> delete(@PathVariable long libro_id) {
        try {
            if (libroServices.read(libro_id).isPresent()) {
                libroServices.delete(libro_id);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Libro no encontrado");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede eliminar el libro porque está asociado a otros registros (por ejemplo, préstamos).");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno del servidor al eliminar el libro");
        }
    }
}
