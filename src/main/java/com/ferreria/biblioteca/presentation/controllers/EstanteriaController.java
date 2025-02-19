/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ferreria.biblioteca.presentation.controllers;

import com.ferreria.biblioteca.business.models.EstanteriaModel;
import com.ferreria.biblioteca.business.services.EstanteriaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oriol
 */


@RestController
@RequestMapping("/estanterias")
public class EstanteriaController {

    @Autowired
    private EstanteriaService estanteriaService;

    @GetMapping
    public List<EstanteriaModel> getEstanterias() {
        return estanteriaService.getEstanterias();
    }

    @GetMapping("/{id}")
    public Optional<EstanteriaModel> getEstanteriaById(@PathVariable Integer id) {
        return estanteriaService.getEstanteriaById(id);
    }

    @PostMapping
    public EstanteriaModel createEstanteria(@RequestBody EstanteriaModel estanteria) {
        return estanteriaService.saveEstanteria(estanteria);
    }

    @PutMapping("/{id}")
    public EstanteriaModel updateEstanteria(@PathVariable Integer id, @RequestBody EstanteriaModel request) {
        return estanteriaService.updateEstanteria(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteEstanteria(@PathVariable Integer id) {
        boolean ok = estanteriaService.deleteEstanteria(id);
        if (ok) {
            return "Estantería con ID " + id + " eliminada!";
        } else {
            return "ERROR: La estantería con ID " + id + " no existe!";
        }
    }
}
