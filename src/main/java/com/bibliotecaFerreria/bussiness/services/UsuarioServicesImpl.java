package com.bibliotecaFerreria.bussiness.services;
/**
 * @author Ruben
 * @date 07/02/2025
 */
import com.bibliotecaFerreria.bussiness.model.Historial;
import com.bibliotecaFerreria.bussiness.model.HistorialDTO;
import com.bibliotecaFerreria.bussiness.model.Usuario;
import com.bibliotecaFerreria.bussiness.model.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    private final TreeMap<String, Usuario> usuarios = new TreeMap<>();
    private final TreeMap<String, UsuarioDTO> usuarioDTO = new TreeMap<>();

    public UsuarioServicesImpl() {
        Usuario usuario1 = new Usuario("12345678A", "Juan Pérez", "password123", "juan.perez@example.com");
        usuario1.setHistorial(new ArrayList<>()); // Inicializando historial vacío
        usuarios.put(usuario1.getDni(), usuario1);
        usuarioDTO.put(usuario1.getDni(), mapToDTO(usuario1));

        Usuario usuario2 = new Usuario("87654321B", "María García", "mariapass", "maria.garcia@example.com");
        usuario2.setHistorial(new ArrayList<>()); // Inicializando historial vacío
        usuarios.put(usuario2.getDni(), usuario2);
        usuarioDTO.put(usuario2.getDni(), mapToDTO(usuario2));

        Usuario usuario3 = new Usuario("11223344C", "Carlos Sánchez", "carlospass", "carlos.sanchez@example.com");
        usuario3.setHistorial(new ArrayList<>()); // Inicializando historial vacío
        usuarios.put(usuario3.getDni(), usuario3);
        usuarioDTO.put(usuario3.getDni(), mapToDTO(usuario3));
    }

    @Override
    public String create(Usuario usuario) {
        if (usuarios.containsKey(usuario.getDni())) {
            throw new IllegalStateException("El usuario con DNI " + usuario.getDni() + " ya existe.");
        }

        if (usuario.getHistorial() != null) {
            for (Historial h : usuario.getHistorial()) {
                h.setUsuario(usuario); // Asociamos el historial con el usuario
            }
        }

        usuarios.put(usuario.getDni(), usuario);
        usuarioDTO.put(usuario.getDni(), mapToDTO(usuario));
        return usuario.getDni();
    }

    @Override
    public Optional<Usuario> read(String dni) {
        System.out.println("Buscando el usuario con DNI: " + dni);
        return Optional.ofNullable(usuarios.get(dni));
    }

    @Override
    public void update(Usuario usuario) {
        if (!usuarios.containsKey(usuario.getDni())) {
            throw new IllegalStateException("El usuario con DNI " + usuario.getDni() + " no existe.");
        }

        if (usuario.getHistorial() != null) {
            for (Historial h : usuario.getHistorial()) {
                h.setUsuario(usuario); // Asociamos el historial con el usuario actualizado
            }
        }

        usuarios.put(usuario.getDni(), usuario);
        usuarioDTO.put(usuario.getDni(), mapToDTO(usuario));
    }

    @Override
    public void delete(String dni) {
        if (!usuarios.containsKey(dni)) {
            throw new IllegalStateException("El usuario con DNI " + dni + " no existe.");
        }

        usuarios.remove(dni);
        usuarioDTO.remove(dni);
    }

    @Override
    public List<UsuarioDTO> getAll() {
        return new ArrayList<>(usuarioDTO.values());
    }

    private UsuarioDTO mapToDTO(Usuario usuario) {
        List<HistorialDTO> historialDTOList = new ArrayList<>();
        if (usuario.getHistorial() != null) {
            for (Historial h : usuario.getHistorial()) {
                historialDTOList.add(HistorialDTO.HistorialMapper.toDTO(h));
            }
        }

        return new UsuarioDTO(usuario.getDni(), usuario.getNombre(), usuario.getCorreoElectronico());
    }
}
