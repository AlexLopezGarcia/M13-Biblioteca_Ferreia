package cat.ferreria.api.bussiness.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estanteria")
public class Estanteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estanteria_id")
    private int estanteriaID;

    @Column(nullable = false)
    private String nombre;

}
