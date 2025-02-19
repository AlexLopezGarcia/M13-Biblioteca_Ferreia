/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferreria.biblioteca.business.services;

import com.ferreria.biblioteca.business.models.EstanteriaModel;
import com.ferreria.biblioteca.business.repositories.IEstanteriaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




/**
 *
 * @author oriol
 */


@Service
public class EstanteriaService {

    @Autowired
    private IEstanteriaRepository estanteriaRepository;

  
    public List<EstanteriaModel> getEstanterias() {
        return estanteriaRepository.findAll();
    }

  
    public EstanteriaModel saveEstanteria(EstanteriaModel estanteria) {
        return estanteriaRepository.save(estanteria);
    }

    
    public Optional<EstanteriaModel> getEstanteriaById(Integer id) {
        return estanteriaRepository.findById(id);
    }

  
    public EstanteriaModel updateEstanteria(Integer id, EstanteriaModel request) {
        Optional<EstanteriaModel> optionalEstanteria = estanteriaRepository.findById(id);
        if (optionalEstanteria.isPresent()) {
            EstanteriaModel estanteria = optionalEstanteria.get();
            estanteria.setNombre(request.getNombre());
            estanteria.setEstante(request.getEstante());
            return estanteriaRepository.save(estanteria);
        }
        return null; 
    }

    
    public boolean deleteEstanteria(Integer id) {
        try {
            estanteriaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
