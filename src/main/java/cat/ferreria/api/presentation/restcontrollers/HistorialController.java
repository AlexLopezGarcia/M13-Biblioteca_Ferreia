package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.clazz.Historial;
import cat.ferreria.api.bussiness.model.dtos.HistorialDTO;
import cat.ferreria.api.bussiness.services.impls.HistorialServicesImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alexl
 * @date 07/02/2025
 */
@RestController
@RequestMapping("/historial")
@Tag(name = "Historial", description = "Gestión de historial de usuarios")
public class HistorialController {

    @Autowired
    private HistorialServicesImpl historialServices;

    @Operation (
            summary = "Obtener todos los registros de historial",
            description = "Devuelve todos los registros de historial",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Registros de historial encontrados"),
                    @ApiResponse(responseCode = "404", description = "Registro de historial no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @GetMapping
    public ResponseEntity<List<HistorialDTO>> getAll() {
        List<HistorialDTO> historialDTOs = historialServices.getAll().stream()
                .map(HistorialDTO.HistorialMapper::toDTO)
                .toList();
        return ResponseEntity.ok(historialDTOs);
    }

    @Operation (
            summary = "Obtener un registro de historial",
            description = "Devuelve un registro de historial por su ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Registro de historial encontrado"),
                    @ApiResponse(responseCode = "404", description = "Registro de historial no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @GetMapping("/{historialId}")
    public ResponseEntity<?> read(@PathVariable Long historialId) {
        return historialServices.read(historialId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation (
            summary = "Crear un registro de historial",
            description = "Crea un registro de historial",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Registro de historial creado"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Historial historial) {
        Long id = historialServices.create(historial);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registro de historial creado con ID: " + id);
    }

    @Operation (
            summary = "Actualizar un registro de historial",
            description = "Actualiza un registro de historial",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Registro de historial actualizado"),
                    @ApiResponse(responseCode = "404", description = "Registro de historial no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @PutMapping("/{historialId}")
    public ResponseEntity<String> update(@PathVariable Long historialId, @RequestBody Historial historial) {
        if (historialServices.read(historialId).isPresent()) {
            historial.setHistorialId(historialId);
            historialServices.update(historial);
            return ResponseEntity.ok("Registro de historial actualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Registro de historial no encontrado");
    }

    @Operation (
            summary = "Eliminar un registro de historial",
            description = "Elimina un registro de historial",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Registro de historial eliminado"),
                    @ApiResponse(responseCode = "404", description = "Registro de historial no encontrado"),
                    @ApiResponse(responseCode = "500", description = "Error interno")
            }
    )
    @DeleteMapping("/{historialId}")
    public ResponseEntity<String> delete(@PathVariable Long historialId) {
        if (historialServices.read(historialId).isPresent()) {
            historialServices.delete(historialId);
            return ResponseEntity.ok("Registro de historial eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Registro de historial no encontrado");
    }
}
