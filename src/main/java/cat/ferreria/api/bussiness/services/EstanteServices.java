package cat.ferreria.api.bussiness.services;

import cat.ferreria.api.bussiness.model.clazz.Estante;
import cat.ferreria.api.bussiness.model.dtos.EstanteDTO;

import java.util.List;
import java.util.Optional;

/**
 * @author alexl
 * @date 14/03/2025
 */
public interface EstanteServices {
    EstanteDTO create(Estante estante);
    Optional<Estante> read(Long id); // Cambiado a Long
    void update(Estante estante);
    void delete(Long id); // Cambiado a Long
    List<Estante> getAll();
}