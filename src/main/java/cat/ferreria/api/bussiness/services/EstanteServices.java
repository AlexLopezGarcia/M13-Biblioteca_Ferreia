package cat.ferreria.api.bussiness.services;

import cat.ferreria.api.bussiness.model.Estante;

import java.util.List;
import java.util.Optional;

/**
 * @author alexl
 * @date 14/03/2025
 */
public interface EstanteServices {
    String create(Estante estante);       // C
    Optional<Estante> read(String id);    // R
    void update(Estante estante);         // U
    void delete(String id);               // D
    List<Estante> getAll(); //Obtener todos los estantes
}
