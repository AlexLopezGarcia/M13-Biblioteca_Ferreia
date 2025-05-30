package cat.ferreria.api.backend.config;

import lombok.Getter;

/**
 * @author alexl
 * Clase para poder devolver un error en el formato correcto
 * */

@Getter
public class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}