package cat.ferreria.api.bussiness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
/**
 * @author alexl
 * @date 14/03/2025
 */
@Entity
@Table(name = "estante")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Estante implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estante_id")
    private Long estante_id;

    @ManyToOne
    @JoinColumn(name = "isbn", nullable = false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "estanteria_id")
    private Estanteria estanteria;
}