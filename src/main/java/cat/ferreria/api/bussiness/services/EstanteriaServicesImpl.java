package com.bibliotecaFerreria.bussiness.services;

import com.bibliotecaFerreria.bussiness.model.Estanteria;
import com.bibliotecaFerreria.bussiness.repository.EstanteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstanteriaServicesImpl implements EstanteriaServices {

    private final EstanteriaRepository estanteriaRepository;

    @Autowired
    public EstanteriaServicesImpl(EstanteriaRepository estanteriaRepository) {
        this.estanteriaRepository = estanteriaRepository;
    }

    @Override
    public int create(Estanteria estanteria) {
        return estanteriaRepository.save(estanteria).getEstanteriaID();
    }

    @Override
    public Optional<Estanteria> read(int id) {
        return estanteriaRepository.findById(id);
    }

    @Override
    public void update(Estanteria estanteria) {
        // Se asume que el objeto 'estanteria' ya contiene el id correcto.
        estanteriaRepository.save(estanteria);
    }

    @Override
    public void delete(int id) {
        estanteriaRepository.deleteById(id);
    }

    @Override
    public List<Estanteria> getAll() {
        return estanteriaRepository.findAll();
    }
}
