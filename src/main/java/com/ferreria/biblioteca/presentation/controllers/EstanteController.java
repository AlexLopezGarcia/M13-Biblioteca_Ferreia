package com.ferreria.biblioteca.presentation.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreria.biblioteca.business.models.Estante;
import com.ferreria.biblioteca.business.services.EstanteService;

@RestController
@RequestMapping("/estante")
public class EstanteController {
	@Autowired
	private EstanteService es;
	
	@GetMapping
	public ArrayList<Estante> getEstantes(){
		return this.es.getEstantes();
	}
}
