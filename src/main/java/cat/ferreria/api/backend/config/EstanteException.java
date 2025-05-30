package cat.ferreria.api.backend.config;

/**
 * @author alexl
 * Exception personalizada para manejar errores relacionados con la estante
 * */

public class EstanteException extends RuntimeException{
    public EstanteException(String message) {super(message);}
}
