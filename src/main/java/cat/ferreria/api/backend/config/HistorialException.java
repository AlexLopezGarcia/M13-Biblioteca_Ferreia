package cat.ferreria.api.backend.config;

/**
 * @author alexl
 * Excepción personalizada para el historial de préstamos.
 * */
public class HistorialException extends RuntimeException{
    public HistorialException(String message) {super(message);}
}
