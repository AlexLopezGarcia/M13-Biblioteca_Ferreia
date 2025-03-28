package cat.ferreria.api.bussiness.model.clazz;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

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
@Table(name = "libro")
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Long libroId;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "categoria")
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "estante_id")
    private Estante estante;

    @Column(name = "estado_uso")
    private boolean estadoUso;

}
