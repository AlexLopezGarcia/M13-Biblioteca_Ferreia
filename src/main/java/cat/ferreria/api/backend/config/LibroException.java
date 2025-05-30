package cat.ferreria.api.backend.config;

/**
 * @author alexl
 * Excepción personalizada para el historial de préstamos.
 * */
public class LibroException extends RuntimeException {
    public LibroException(String message) {
        super(message);
    }
}