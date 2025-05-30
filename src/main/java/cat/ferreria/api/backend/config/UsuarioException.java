package cat.ferreria.api.backend.config;

/**
 * @author alexl
 * Excepción personalizada para el historial de préstamos.
 * */
public class UsuarioException extends RuntimeException{
    public UsuarioException(String message){super(message);}
}
