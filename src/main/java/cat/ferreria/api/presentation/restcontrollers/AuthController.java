package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.configs.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
/**
 * EndPoint(/auth)
 */
 /**
 * @author alexl
 * @date 07/02/2025
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "Autentificador", description = "Controlador para generar a autentificación")
public class AuthController {
     //Inicializa JwtUtil
    private final JwtTokenProvider jwtTokenProvider;
     private static final Logger _log = LoggerFactory.getLogger(AuthController.class);

    public AuthController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * EndPoint: /auth/login?username=user&password=password
     * @param username recibe un usuario
     * @param password recibe una contraseña
     * @return Devuelve el token si encuentra un usuario con esa contraseña
     * o credenciales inválidas si no existe
     */
    @Operation(summary = "Login", description = "Genera el token en base al user/passwd")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        try {
            _log.info("Intento de login recibido para username: {}", username);

            if ("admin".equals(username) && "admin".equals(password)) {
                String token = jwtTokenProvider.createToken(username);
                _log.info("Token generado correctamente para {}", username);
                return ResponseEntity.ok(Map.of("token", token));
            }

            _log.warn("Credenciales inválidas para username: {}", username);
            return ResponseEntity.status(401).body("Credenciales inválidas");

        } catch (Exception e) {
            _log.error("Error en login para username {}: {}", username, e.getMessage(), e);
            return ResponseEntity.status(500).body(Map.of(
                    "status", 500,
                    "message", "Error interno del servidor"
            ));
        }
    }
}

