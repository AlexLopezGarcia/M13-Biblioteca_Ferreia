package com.bibliotecaFerreria.bussiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotecaFerreria.bussiness.model.Estante;

public interface EstanteRepository extends JpaRepository<Estante, Integer>{
	
}
