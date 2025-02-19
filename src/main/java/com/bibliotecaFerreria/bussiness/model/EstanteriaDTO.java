package com.bibliotecaFerreria.bussiness.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstanteriaDTO {
    private int estanteriaID;
    private String nombre;

    public static EstanteriaDTO fromEntity(Estanteria estanteria) {
        return new EstanteriaDTO(
                estanteria.getEstanteriaID(),
                estanteria.getNombre()
        );
    }
}
