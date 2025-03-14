package cat.ferreria.api.bussiness.model;

import lombok.*;

/**
 * @author alexl
 * @date 14/03/2025
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class EstanteDTO {
    private int estante_id;
    private String isbn;
    private int estanteria_id;
    private LibroDTO libro;
    private EstanteriaDTO estanteria;

    public static class EstanteMapper {
        public static EstanteDTO toDTO(Estante estante) {
            return new EstanteDTO(
                    estante.getEstante_id(),
                    estante.getIsbn(),
                    estante.getEstanteria_id(),
                    LibroDTO.LibroMapper.toDTO(estante.getLibro()),
                    EstanteriaDTO.EstanteriaMapper.toDTO(estante.getEstanteria())
            );
        }
    }
}
