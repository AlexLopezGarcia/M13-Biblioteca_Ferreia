package com.ferreria.biblioteca.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferreria.biblioteca.business.models.Estante;

public interface IEstanteRepository extends JpaRepository<Estante, Integer>{
	
}
