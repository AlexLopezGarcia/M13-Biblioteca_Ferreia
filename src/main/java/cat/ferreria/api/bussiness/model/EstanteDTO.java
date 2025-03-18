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
    private Long estante_id;
    private String isbn;
    private Long estanteria_id;
    private LibroDTO libro;
    private EstanteriaDTO estanteria;

    public static class EstanteMapper {
        public static EstanteDTO toDTO(Estante estante) {
            Estanteria estanteria = estante.getEstanteria();
            return new EstanteDTO(
                    estante.getEstante_id(),
                    estante.getLibro().getIsbn(),
                    estanteria != null ? estanteria.getEstanteriaId() : null,
                    LibroDTO.LibroMapper.toDTO(estante.getLibro()),
                    estanteria != null ? EstanteriaDTO.EstanteriaMapper.toDTO(estanteria) : null
            );
        }
    }
}