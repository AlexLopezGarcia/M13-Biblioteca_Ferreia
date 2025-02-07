package com.bibliotecaFerreria.presentation.restcontrollers;

import com.bibliotecaFerreria.bussiness.model.Historial;
import com.bibliotecaFerreria.bussiness.model.HistorialDTO;
import com.bibliotecaFerreria.bussiness.services.HistorialServicesImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<HistorialDTO>> getAll() {
        List<HistorialDTO> historialDTOs = historialServices.getAll().stream()
                .map(HistorialDTO.HistorialMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(historialDTOs);
    }

    @GetMapping("/{historialId}")
    public ResponseEntity<?> read(@PathVariable Long historialId) {
        return historialServices.read(historialId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Historial historial) {
        Long id = historialServices.create(historial);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registro de historial creado con ID: " + id);
    }

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