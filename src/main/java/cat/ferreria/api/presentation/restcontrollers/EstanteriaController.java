package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.Estanteria;
import cat.ferreria.api.bussiness.model.EstanteriaDTO;
import cat.ferreria.api.bussiness.services.EstanteriaServicesImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estanterias")
@Tag(name = "Estanterías", description = "Gestión de estanterías")
public class EstanteriaController {

    @Autowired
    private EstanteriaServicesImpl estanteriaServices;


    @GetMapping
    public ResponseEntity<List<EstanteriaDTO>> getAll() {
        List<EstanteriaDTO> dtos = estanteriaServices.getAll()
                .stream()
                .map(EstanteriaDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EstanteriaDTO> read(@PathVariable int id) {
        return estanteriaServices.read(id)
                .map(est -> ResponseEntity.ok(EstanteriaDTO.fromEntity(est)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<String> create(@RequestBody Estanteria estanteria) {
        int id = estanteriaServices.create(estanteria);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Estantería creada con ID: " + id);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Estanteria estanteria) {
        if (estanteriaServices.read(id).isPresent()) {
            estanteria.setEstanteriaID(id);
            estanteriaServices.update(estanteria);
            return ResponseEntity.ok("Estantería actualizada");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Estantería no encontrada");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (estanteriaServices.read(id).isPresent()) {
            estanteriaServices.delete(id);
            return ResponseEntity.ok("Estantería eliminada");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Estantería no encontrada");
    }
}
