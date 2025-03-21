package cat.ferreria.api.bussiness.model.clazz;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * @author oriol
 * @date 07/02/2025
 */
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estanteria")
public class Estanteria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estanteria_id")
    private Long estanteriaId;

    @Column(name = "estante_id")
    private Long estanteId;

    @Column(nullable = false)
    private String nombre;
}
