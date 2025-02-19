package com.bibliotecaFerreria.bussiness.model;

import jakarta.persistence.*;
import java.io.Serializable;

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
    @Column(name = "historial_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historialId;

    @ManyToOne
    @JoinColumn(name = "dni", nullable = false)
    private Usuario usuario;

    @Column(name = "isbn", nullable = false, length = 50)
    private String isbn;
}
