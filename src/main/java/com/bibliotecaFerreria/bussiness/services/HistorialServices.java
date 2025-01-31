package com.bibliotecaFerreria.bussiness.services;

import com.bibliotecaFerreria.bussiness.model.Historial;

import java.util.List;
import java.util.Optional;

public interface HistorialServices {
    Long create(Historial historial);
    Optional<Historial> read(Long historialId);
    void update(Historial historial);
    void delete(Long historialId);
    List<Historial> getAll();
}