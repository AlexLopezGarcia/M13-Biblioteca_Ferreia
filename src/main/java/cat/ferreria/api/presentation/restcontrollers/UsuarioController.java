package cat.ferreria.api.presentation.restcontrollers;
/**
 * @author Ruben
 * @date 07/02/2025
 */
import cat.ferreria.api.bussiness.model.Usuario;
import cat.ferreria.api.bussiness.model.UsuarioDTO;
import cat.ferreria.api.bussiness.services.UsuarioServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuarios", description = "Gestión de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServices usuarioServices;

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAll() {
        List<UsuarioDTO> usuarios = usuarioServices.getAll();
        return ResponseEntity.ok(usuarios);
    }

    // Obtener un usuario por DNI
    @GetMapping("/{dni}")
    public ResponseEntity<?> read(@PathVariable String dni) {
        return usuarioServices.read(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Usuario usuario) {
        try {
            String dni = usuarioServices.create(usuario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Usuario creado con DNI: " + dni);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error al crear el usuario: " + e.getMessage());
        }
    }

    // Actualizar un usuario
    @PutMapping("/{dni}")
    public ResponseEntity<String> update(@PathVariable String dni, @RequestBody Usuario usuario) {
        if (usuarioServices.read(dni).isPresent()) {
            usuario.setDni(dni);
            usuarioServices.update(usuario);
            return ResponseEntity.ok("Usuario actualizado correctamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado.");
    }

    // Eliminar un usuario
    @DeleteMapping("/{dni}")
    public ResponseEntity<String> delete(@PathVariable String dni) {
        if (usuarioServices.read(dni).isPresent()) {
            usuarioServices.delete(dni);
            return ResponseEntity.ok("Usuario eliminado correctamente.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado.");
    }

    @PostMapping("/sesion")
    public ResponseEntity<String> iniciarSesion(@RequestParam String correoElectronico, @RequestParam String contrasenya) {
        String resultadoLogin = usuarioServices.iniciarSesion(correoElectronico, contrasenya);

        return resultadoLogin.equals("Sesión iniciada con éxito")
                ? ResponseEntity.ok(resultadoLogin)
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultadoLogin);
    }
}



