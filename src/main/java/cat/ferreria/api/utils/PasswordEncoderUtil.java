package cat.ferreria.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Codificador de contraseñas utilizando BCrypt.
 *
 * @author alexl
 * @date 10/05/2025
 * */

public class PasswordEncoderUtil {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String[] passwords = {"password123", "contra"};
        for (String password : passwords) {
            String encoded = encoder.encode(password);
            System.out.println("Password: " + password + " -> Encoded: " + encoded);
        }
    }
}