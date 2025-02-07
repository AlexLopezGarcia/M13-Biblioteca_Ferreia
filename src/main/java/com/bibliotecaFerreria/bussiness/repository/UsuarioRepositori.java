package com.bibliotecaFerreria.bussiness.repository;

import com.bibliotecaFerreria.bussiness.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alexl
 * @date 07/02/2025
 */
@Repository
public interface UsuarioRepositori extends JpaRepository<Usuario, String> { 
}
