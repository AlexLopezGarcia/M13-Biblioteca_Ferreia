package com.bibliotecaFerreria.bussiness.repository;

import com.bibliotecaFerreria.bussiness.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {
    List<Historial> findByUsuarioDni(String dni);
    List<Historial> findByIsbn(String isbn);
}