package com.bibliotecaFerreria.bussiness.repository;

import com.bibliotecaFerreria.bussiness.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {
    List<Libro> findByAutor(String autor);
    List<Libro> findByCategoria(String categoria);

    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:keyword%")
    List<Libro> findByTitleContaining(@Param("keyword") String keyword);
}