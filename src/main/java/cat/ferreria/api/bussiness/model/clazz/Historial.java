package cat.ferreria.api.bussiness.model.clazz;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "historial")
public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historial_id")
    private Long historialId;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private Libro libro;

    @Column(name = "fecha_prestamo")
    private LocalDateTime fechaPrestamo;

    @Column(name = "fecha_devolucion")
    private LocalDateTime fechaDevolucion;

}
