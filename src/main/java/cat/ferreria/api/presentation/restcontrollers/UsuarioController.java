package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.clazz.Usuario;
import cat.ferreria.api.bussiness.model.dtos.UsuarioDTO;
import cat.ferreria.api.bussiness.services.interfaces.UsuarioServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de usuarios.
 *
 * @author Ruben
 * @date 16/04/2025
 * */

@RestController
@RequestMapping("/private/usuarios")
@Tag(name = "Usuarios", description = "Gestión de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> usuarios = usuarioServices.getAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<?> read(@PathVariable String dni) {
        return usuarioServices.read(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody Usuario usuario) {
        try {
            String dni = usuarioServices.create(usuario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Usuario creado con DNI: " + dni);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear el usuario: " + e.getMessage());
        }
    }

    @PutMapping("/{dni}")
    public ResponseEntity<String> update(@PathVariable String dni, @Valid @RequestBody Usuario usuario) {
        if (usuarioServices.read(dni).isPresent()) {
            usuario.setDni(dni);
            usuarioServices.update(usuario);
            return ResponseEntity.ok("Usuario actualizado correctamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado.");
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<String> delete(@PathVariable String dni) {
        if (usuarioServices.read(dni).isPresent()) {
            usuarioServices.delete(dni);
            return ResponseEntity.ok("Usuario eliminado correctamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado.");
    }
}