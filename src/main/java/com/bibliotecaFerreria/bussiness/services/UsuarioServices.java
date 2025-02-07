package com.bibliotecaFerreria.bussiness.services;
/**
 * @author Ruben
 * @date 07/02/2025
 */
import com.bibliotecaFerreria.bussiness.model.Usuario;
import com.bibliotecaFerreria.bussiness.model.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioServices {

    String create(Usuario usuario);
    Optional<Usuario> read(String dni);
    void update(Usuario usuario);
    void delete(String dni);
    List<UsuarioDTO> getAll();
}
