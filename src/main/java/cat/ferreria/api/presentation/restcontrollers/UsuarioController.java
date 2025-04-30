package cat.ferreria.api.presentation.restcontrollers;
/**
 * @author Ruben
 * @date 07/02/2025
 */
import cat.ferreria.api.bussiness.model.clazz.Usuario;
import cat.ferreria.api.bussiness.model.dtos.UsuarioDTO;
import cat.ferreria.api.bussiness.services.interfaces.UsuarioServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{dni}")
    public ResponseEntity<String> update(@PathVariable String dni, @RequestBody Usuario usuarioNuevo) {
        Optional<Usuario> usuarioExistente = usuarioServices.read(dni);

        if (usuarioExistente.isPresent()) {
            Usuario antiguo = usuarioExistente.get();

            String contrasenyaOriginal = antiguo.getContrasenya();

            usuarioServices.delete(dni);

            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setDni(usuarioNuevo.getDni());  // Nuevo DNI
            nuevoUsuario.setNombre(usuarioNuevo.getNombre());
            nuevoUsuario.setCorreoElectronico(usuarioNuevo.getCorreoElectronico());
            nuevoUsuario.setContrasenya(contrasenyaOriginal);  // Mantenemos la contraseña original

            usuarioServices.create(nuevoUsuario);

            return ResponseEntity.ok("Usuario actualizado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
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
        //Comprobar si existe el usuario throw if not exists 404
        //Comprobar si la contraseña es throw if not unauthorized
        //Si es correcto los dos entonces 200(1)(todo ok)

        return resultadoLogin.equals("Sesión iniciada con éxito")
                ? ResponseEntity.ok(resultadoLogin)
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultadoLogin);
    }
}



