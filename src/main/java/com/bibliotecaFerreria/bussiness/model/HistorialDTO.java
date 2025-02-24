package com.bibliotecaFerreria.bussiness.model;

import lombok.*;

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
    private String dni;
    private String isbn;

    public static class HistorialMapper {
        public static HistorialDTO toDTO(Historial historial) {
            return new HistorialDTO(
                    historial.getHistorialId(),
                    historial.getUsuario().getDni(),
                    historial.getIsbn()
            );
        }
    }
}
