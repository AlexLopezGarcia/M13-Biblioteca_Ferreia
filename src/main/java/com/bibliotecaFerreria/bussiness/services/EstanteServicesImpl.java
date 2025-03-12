package com.bibliotecaFerreria.bussiness.services;

import com.bibliotecaFerreria.bussiness.model.Estante;
import com.bibliotecaFerreria.bussiness.repository.EstanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author alexh
 * @date 11/03/2025
 */

@Service
public class EstanteServicesImpl implements EstanteServices{
    private final EstanteRepository estanteRepo;

    @Autowired
    public EstanteServicesImpl(EstanteRepository estanteRepo) {
        this.estanteRepo = estanteRepo;
    }

    @Override
    public ArrayList<Estante> getEstantes() {
        return (ArrayList<Estante>) estanteRepo.findAll();
    }

    @Override
    public Estante saveEstante(Estante estante) {
        return estanteRepo.save(estante);
    }

    @Override
    public Optional<Estante> getById(int id) {
        return estanteRepo.findById(id);
    }

    @Override
    public Estante updateById(Estante request, int id) {
        Estante estante = estanteRepo.findById(id).get();
        estante.setLibro(request.getLibro());
        return estante;
    }

    @Override
    public Boolean deleteEstante(int id) {
        try {
            estanteRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
