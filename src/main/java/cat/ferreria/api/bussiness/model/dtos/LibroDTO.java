package cat.ferreria.api.bussiness.model.dtos;

import cat.ferreria.api.bussiness.model.clazz.Libro;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


/**
 * DTO para libro en la API.
 *
 * @author alexl
 * @date 18/02/2025
 * */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LibroDTO {
    @JsonProperty("libroId")
    private Long libroId;
    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;
    @JsonProperty("estadoUso")
    private boolean estadoUso;

    public static class LibroMapper {
        public static LibroDTO toDTO(Libro libro) {
            return new LibroDTO(
                    libro.getLibroId(),
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getCategoria(),
                    libro.getEstadoUso()
            );
        }
    }
}