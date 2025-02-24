package com.bibliotecaFerreria.bussiness.services;

import com.bibliotecaFerreria.bussiness.model.Historial;
import com.bibliotecaFerreria.bussiness.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Service
public class HistorialServicesImpl implements HistorialServices {
    private final HistorialRepository historialRepository;

    @Autowired
    public HistorialServicesImpl(HistorialRepository historialRepository) {
        this.historialRepository = historialRepository;
    }

    @Override
    public Optional<Historial> read(Long historialId) {
        return historialRepository.findById(historialId);
    }

    @Override
    public Long create(Historial historial) {
        return historialRepository.save(historial).getHistorialId();
    }

    @Override
    public void update(Historial historial) {
        historialRepository.save(historial);
    }

    @Override
    public void delete(Long historialId) {
        historialRepository.deleteById(historialId);
    }

    @Override
    public List<Historial> getAll() {
        return historialRepository.findAll();
    }
}