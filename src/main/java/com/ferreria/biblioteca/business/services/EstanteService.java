package com.ferreria.biblioteca.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

import com.ferreria.biblioteca.business.models.Estante;
import com.ferreria.biblioteca.business.repositories.IEstanteRepository;

@Service

public class EstanteService {
	@Autowired
	IEstanteRepository estanteRepo;

	/**
	 * Devuelve todos los estantes.
	 * 
	 * @return
	 */
	public ArrayList<Estante> getEstantes() {
		return (ArrayList<Estante>) estanteRepo.findAll();
	}

	/**
	 * 
	 * @param estante
	 * @return
	 */
	public Estante saveEstante(Estante estante) {
		return estanteRepo.save(estante);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Optional<Estante> getById(int id) {
		return estanteRepo.findById(id);
	}
	
	/**
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	public Estante updateById(Estante request, int id) {
        Estante estante = estanteRepo.findById(id).get();
        estante.setLibro(request.getLibro());
        return estante;
    }
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Boolean deleteEstante(int id) {
        try {
        	estanteRepo.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

}
