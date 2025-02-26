package com.bibliotecaFerreria.bussiness.repository;

import com.bibliotecaFerreria.bussiness.model.Estanteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstanteriaRepository extends JpaRepository<Estanteria, Integer> {
}
