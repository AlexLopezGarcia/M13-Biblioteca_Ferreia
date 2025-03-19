package cat.ferreria.api.bussiness.model.clazz;
/**
 * @author Ruben
 * @date 18/02/2025
 */
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

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

    @Column(name = "correo_electronico", nullable = false, unique = true)
    private String correoElectronico;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Historial> historial;
    

}