package cat.ferreria.api.bussiness.model;

import lombok.*;

/**
 * DTO para la entidad Estanteria.
 *
 * @author oriol
 * @date 07/02/2025
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EstanteriaDTO {
    private Long estanteriaId;
    private Long estanteId;
    private String nombre;

    public static class EstanteriaMapper {
        public static EstanteriaDTO toDTO(Estanteria estanteria) {
            return new EstanteriaDTO(
                    estanteria.getEstanteriaId(),
                    estanteria.getEstanteId(),
                    estanteria.getNombre()
            );
        }
    }
}
