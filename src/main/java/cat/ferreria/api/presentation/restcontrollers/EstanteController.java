package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.clazz.Estante;
import cat.ferreria.api.bussiness.model.dtos.EstanteDTO;
import cat.ferreria.api.bussiness.services.interfaces.EstanteServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para Estante
 *
 * @author alexl
 * @date 14/03/2025
 */
@RestController
@RequestMapping("/estantes")
@Tag(name = "Estantes", description = "Gestión de estantes")
public class EstanteController {

    @Autowired
    private EstanteServices estanteServices;

    @Operation(summary = "Obtener todos los estantes", description = "Devuelve todos los estantes registrados")
    @GetMapping
    public ResponseEntity<List<Estante>> getAll() {
        return ResponseEntity.ok(estanteServices.getAll());
    }

    @Operation(summary = "Obtener un estante", description = "Devuelve un estante por su ID")
    @GetMapping("/{estanteId}")
    public ResponseEntity<EstanteDTO> read(@PathVariable Long estanteId) {
        return estanteServices.read(estanteId)
                .map(estante -> ResponseEntity.ok(EstanteDTO.EstanteMapper.toDTO(estante)))
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un estante", description = "Crea un nuevo estante")
    @PostMapping
    public ResponseEntity<EstanteDTO> create(@RequestBody Estante estante) {
        EstanteDTO createdEstante = estanteServices.create(estante);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEstante);
    }

    @Operation(summary = "Actualizar un estante", description = "Actualiza un estante existente")
    @PutMapping("/{estanteId}")
    public ResponseEntity<String> update(@PathVariable Long estanteId, @RequestBody Estante estante) {
        if (estanteServices.read(estanteId).isPresent()) {
            estante.setEstante_id(estanteId);
            estanteServices.update(estante);
            return ResponseEntity.ok("Estante actualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estante no encontrado");
    }

    @Operation(summary = "Eliminar un estante", description = "Elimina un estante por su ID")
    @DeleteMapping("/{estanteId}")
    public ResponseEntity<String> delete(@PathVariable Long estanteId) {
        if (estanteServices.read(estanteId).isPresent()) {
            estanteServices.delete(estanteId);
            return ResponseEntity.ok("Estante eliminado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estante no encontrado");
    }
}