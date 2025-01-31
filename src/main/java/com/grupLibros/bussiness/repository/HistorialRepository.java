package com.grupLibros.bussiness.repository;

import com.grupLibros.bussiness.model.Historial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> {
    List<Historial> findByUsuarioDni(String dni);
    List<Historial> findByIsbn(String isbn);
}