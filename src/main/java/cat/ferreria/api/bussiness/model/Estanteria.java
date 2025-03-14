package cat.ferreria.api.bussiness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "estanteria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estanteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estanteria_id")
    private int estanteriaID;

    @Column(nullable = false)
    private String nombre;
}