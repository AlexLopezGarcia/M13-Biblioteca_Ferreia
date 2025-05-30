package cat.ferreria.api.bussiness.model.dtos;

import cat.ferreria.api.bussiness.model.clazz.Estante;
import cat.ferreria.api.bussiness.model.clazz.Estanteria;
import lombok.*;

/**
 * DTO para la entidad Estante.
 *
 * @author alexl
 * @date 14/03/2025
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EstanteDTO {
    private Long estante_id;
    private Long estanteria_id;
    private EstanteriaDTO estanteria;

    public static class EstanteMapper {
        public static EstanteDTO toDTO(Estante estante) {
            Estanteria estanteria = estante.getEstanteria();
            return new EstanteDTO(
                    estante.getEstante_id(),
                    estanteria != null ? estanteria.getEstanteriaId() : null,
                    estanteria != null ? EstanteriaDTO.EstanteriaMapper.toDTO(estanteria) : null
            );
        }
    }
}