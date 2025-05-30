package cat.ferreria.api.bussiness.model.clazz;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Ruben
 * @date 18/02/2025
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "dni")
    private String dni;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String contrasenya;

    @Column(name = "correo_electronico", nullable = false)
    private String correoElectronico;

}