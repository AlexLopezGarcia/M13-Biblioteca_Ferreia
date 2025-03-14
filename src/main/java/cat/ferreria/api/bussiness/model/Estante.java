package cat.ferreria.api.bussiness.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

/**
 * @author alexl
 * @date 14/03/2025
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table (name = "estante")
public class Estante implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int estante_id;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private int estanteria_id;

    @ManyToOne
    @JoinColumn(name = "isbn", nullable = false)
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "estanteria_id")
    private Estanteria estanteria;
}
