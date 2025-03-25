package cat.ferreria.api.bussiness.model.dtos;

import cat.ferreria.api.bussiness.model.clazz.Historial;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class HistorialDTO {
    private Long historialId;
    private String dni;            // ID del usuario asociado
    private Long libroId;          // ID del libro asociado
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    public static class HistorialMapper {
        public static HistorialDTO toDTO(Historial historial) {
            return new HistorialDTO(
                    historial.getHistorialId(),
                    historial.getUsuario().getDni(),
                    historial.getLibro().getLibroId(),
                    historial.getFechaPrestamo(),
                    historial.getFechaDevolucion()
            );
        }
    }
}
