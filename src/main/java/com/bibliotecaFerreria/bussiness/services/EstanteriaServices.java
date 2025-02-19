package com.bibliotecaFerreria.bussiness.services;

import com.bibliotecaFerreria.bussiness.model.Estanteria;
import java.util.List;
import java.util.Optional;

public interface EstanteriaServices {
    int create(Estanteria estanteria);
    Optional<Estanteria> read(int id);
    void update(Estanteria estanteria);
    void delete(int id);
    List<Estanteria> getAll();
}
