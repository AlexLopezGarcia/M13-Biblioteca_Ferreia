package com.bibliotecaFerreria.bussiness.services;

import com.bibliotecaFerreria.bussiness.model.Estanteria;
import java.util.List;
import java.util.Optional;

public interface EstanteriaServices {
    Integer create(Estanteria estanteria);
    Optional<Estanteria> read(Integer id);
    void update(Estanteria estanteria);
    void delete(Integer id);
    List<Estanteria> getAll();
}
