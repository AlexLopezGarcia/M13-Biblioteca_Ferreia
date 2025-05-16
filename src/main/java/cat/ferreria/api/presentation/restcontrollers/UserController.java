package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.clazz.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author alexl
 * @date 16/05/2025
 */
@RestController
@RequestMapping("/auth")
public class UserController {
    private static final Logger _log = LoggerFactory.getLogger(UserController.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<?> register(@RequestBody Map<String, String> userData) {
        try {
            String dni = userData.get("dni");
            String nombre = userData.get("nombre");
            String contrasenya = userData.get("contrasenya");
            String correoElectronico = userData.get("correoElectronico");

            if (dni == null || nombre == null || contrasenya == null || correoElectronico == null) {
                _log.warn("Datos de registro incompletos");
                return ResponseEntity.badRequest().body(Map.of("error", "Todos los campos son obligatorios"));
            }

            if (!dni.matches("^[0-9]{8}[A-Z]$")) {
                _log.warn("DNI inválido: {}", dni);
                return ResponseEntity.badRequest().body(Map.of("error", "DNI inválido"));
            }

            Usuario existingUser = entityManager
                    .createQuery("SELECT u FROM Usuario u WHERE u.dni = :dni OR u.correoElectronico = :correo", Usuario.class)
                    .setParameter("dni", dni)
                    .setParameter("correo", correoElectronico)
                    .getResultList()
                    .stream()
                    .findFirst()
                    .orElse(null);

            if (existingUser != null) {
                _log.warn("Usuario ya existe: DNI={} o Correo={}", dni, correoElectronico);
                return ResponseEntity.badRequest().body(Map.of("error", "El DNI o correo ya está registrado"));
            }

            String encodedPassword = passwordEncoder.encode(contrasenya);

            Usuario usuario = new Usuario();
            usuario.setDni(dni);
            usuario.setNombre(nombre);
            usuario.setContrasenya(encodedPassword);
            usuario.setCorreoElectronico(correoElectronico);

            entityManager.persist(usuario);
            _log.info("Usuario registrado exitosamente: {}", dni);

            return ResponseEntity.ok(Map.of("message", "Usuario registrado exitosamente"));
        } catch (Exception e) {
            _log.error("Error al registrar usuario: {}", e.getMessage(), e);
            return ResponseEntity.status(500).body(Map.of("error", "Error al registrar usuario"));
        }
    }
}