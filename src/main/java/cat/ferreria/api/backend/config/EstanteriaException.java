package cat.ferreria.api.backend.config;

// Exception personalizada para manejar errores relacionados con la estantería
public class EstanteriaException extends RuntimeException {
    public EstanteriaException(String message) {
        super(message);
    }
}