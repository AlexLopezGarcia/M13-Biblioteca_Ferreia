package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.clazz.Estanteria;
import cat.ferreria.api.bussiness.model.dtos.EstanteriaDTO;
import cat.ferreria.api.bussiness.services.interfaces.EstanteriaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author alexl
 * @date 07/02/2025
 */
@RestController
@RequestMapping("/estanterias")
@Tag(name = "Estanterias", description = "Gestión de estanterías")
public class EstanteriaController {

    @Autowired
    private EstanteriaServices estanteriaServices;

    @Operation(
            summary = "Obtener todas las estanterías",
            description = "Devuelve todas las estanterías registradas",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Estanterías encontradas"),
                    @ApiResponse(responseCode = "404", description = "Estantería no encontrada",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<EstanteriaDTO>> getAll() {
        List<EstanteriaDTO> estanteriaDTOs = estanteriaServices.getAll().stream()
                .map(estanteria -> new EstanteriaDTO(
                        estanteria.getEstanteriaId(),
                        estanteria.getNombre()
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(estanteriaDTOs);
    }

    @Operation(
            summary = "Obtener una estantería",
            description = "Devuelve una estantería por su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Estantería encontrada"),
                    @ApiResponse(responseCode = "404", description = "Estantería no encontrada",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @GetMapping("/{estanteriaId}")
    public ResponseEntity<EstanteriaDTO> read(@PathVariable Long estanteriaId) {
        return estanteriaServices.read(estanteriaId)
                .map(estanteria -> ResponseEntity.ok(new EstanteriaDTO(
                        estanteria.getEstanteriaId(),
                        estanteria.getNombre()
                )))
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(
            summary = "Crear una estantería",
            description = "Crea una nueva estantería",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Estantería creada"),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Estanteria estanteria) {
        Long id = estanteriaServices.create(estanteria);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Estantería creada con ID: " + id);
    }

    @Operation(
            summary = "Actualizar una estantería",
            description = "Actualiza una estantería existente",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Estantería actualizada"),
                    @ApiResponse(responseCode = "404", description = "Estantería no encontrada",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @PutMapping("/{estanteriaId}")
    public ResponseEntity<String> update(@PathVariable Long estanteriaId, @RequestBody Estanteria estanteria) {
        if (estanteriaServices.read(estanteriaId).isPresent()) {
            estanteria.setEstanteriaId(estanteriaId);
            estanteriaServices.update(estanteria);
            return ResponseEntity.ok("Estantería actualizada");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estantería no encontrada");
    }

    @Operation(
            summary = "Eliminar una estantería",
            description = "Elimina una estantería por su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Estantería eliminada"),
                    @ApiResponse(responseCode = "404", description = "Estantería no encontrada",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Error interno",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
            }
    )
    @DeleteMapping("/{estanteriaId}")
    public ResponseEntity<String> delete(@PathVariable Long estanteriaId) {
        if (estanteriaServices.read(estanteriaId).isPresent()) {
            estanteriaServices.delete(estanteriaId);
            return ResponseEntity.ok("Estantería eliminada");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estantería no encontrada");
    }
}
