package cat.ferreria.api.bussiness.model.dtos;

import cat.ferreria.api.bussiness.model.clazz.Libro;
import lombok.*;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class LibroDTO {
    private Long libro_id;
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    private Long estante_id;

    public static class LibroMapper {
        public static LibroDTO toDTO(Libro libro) {
            return new LibroDTO(
                    libro.getLibroId(),
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getCategoria(),
                    libro.getEstante().getEstante_id()
            );
        }
    }
}
