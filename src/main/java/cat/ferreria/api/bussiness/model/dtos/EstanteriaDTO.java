package cat.ferreria.api.bussiness.model.dtos;

import cat.ferreria.api.bussiness.model.clazz.Estanteria;
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
    private String nombre;

    public static class EstanteriaMapper {
        public static EstanteriaDTO toDTO(Estanteria estanteria) {
            return new EstanteriaDTO(
                    estanteria.getEstanteriaId(),
                    estanteria.getNombre()
            );
        }
    }
}
