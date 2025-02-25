package com.bibliotecaFerreria.bussiness.repository;
/**
 * @author Ruben
 * @date 18/02/2025
 */
import com.bibliotecaFerreria.bussiness.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositori extends JpaRepository<Usuario, String> { 
}
