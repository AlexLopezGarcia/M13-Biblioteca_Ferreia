package cat.ferreria.api.bussiness.model.clazz;

import jakarta.persistence.*;
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

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libroId;

    private String isbn;
    private String titulo;
    private String autor;
    private String categoria;

    @Column(name = "estado_uso")
    private Boolean estadoUso;

    @ManyToOne
    @JoinColumn(name = "estante_id")
    private Estante estante;

}