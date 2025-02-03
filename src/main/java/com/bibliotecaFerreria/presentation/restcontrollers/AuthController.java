package com.bibliotecaFerreria.presentation.restcontrollers;


import com.bibliotecaFerreria.bussiness.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * EndPoint(/auth)
 */
@RestController
@RequestMapping("login/auth")
public class AuthController {
    //Inicializa JwtUtil
    @Autowired
    private JwtTokenProvider jwtUtil;
    /**
     * EndPoint: /auth/login?username=user&password=password
     * @param username recibe un usuario
     * @param password recibe una contraseña
     * @return Devuelve el token si encuentra un usuario con esa contraseña
     * o credenciales inválidas si no existe
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        // Aquí deberías validar el username y password con tu base de datos
        if ("admin".equals(username) && "admin".equals(password)) {
            String token = jwtUtil.createToken(username);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
    }
}

