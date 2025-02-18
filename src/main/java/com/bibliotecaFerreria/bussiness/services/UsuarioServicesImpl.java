package com.bibliotecaFerreria.bussiness.services;
/**
 * @author Ruben
 * @date 18/02/2025
 */

import com.bibliotecaFerreria.bussiness.model.Historial;
import com.bibliotecaFerreria.bussiness.model.HistorialDTO;
import com.bibliotecaFerreria.bussiness.model.Usuario;
import com.bibliotecaFerreria.bussiness.model.UsuarioDTO;
import com.bibliotecaFerreria.bussiness.repository.UsuarioRepositori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    private final UsuarioRepositori usuarioRepository;

    @Autowired
    public UsuarioServicesImpl(UsuarioRepositori usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public String create(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getDni())) {
            throw new IllegalStateException("El usuario con DNI " + usuario.getDni() + " ya existe.");
        }

        if (usuario.getHistorial() != null) {
            for (Historial h : usuario.getHistorial()) {
                h.setUsuario(usuario);
            }
        }

        usuarioRepository.save(usuario);
        return usuario.getDni();
    }

    @Override
    public Optional<Usuario> read(String dni) {
        return usuarioRepository.findById(dni);
    }

    @Override
    public void update(Usuario usuario) {
        if (!usuarioRepository.existsById(usuario.getDni())) {
            throw new IllegalStateException("El usuario con DNI " + usuario.getDni() + " no existe.");
        }

        if (usuario.getHistorial() != null) {
            for (Historial h : usuario.getHistorial()) {
                h.setUsuario(usuario);
            }
        }

        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(String dni) {
        if (!usuarioRepository.existsById(dni)) {
            throw new IllegalStateException("El usuario con DNI " + dni + " no existe.");
        }

        usuarioRepository.deleteById(dni);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return usuarioRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private UsuarioDTO mapToDTO(Usuario usuario) {
        List<HistorialDTO> historialDTOList = usuario.getHistorial() != null
                ? usuario.getHistorial().stream()
                .map(HistorialDTO.HistorialMapper::toDTO)
                .collect(Collectors.toList())
                : List.of();

        return new UsuarioDTO(usuario.getDni(), usuario.getNombre(), usuario.getCorreoElectronico());
    }
}
