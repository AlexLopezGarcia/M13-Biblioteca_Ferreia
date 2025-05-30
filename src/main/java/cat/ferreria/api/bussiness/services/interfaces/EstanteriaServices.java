package cat.ferreria.api.bussiness.services.interfaces;

import cat.ferreria.api.bussiness.model.clazz.Estanteria;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz de servicios para Estanteria.
 *
 * @author oriol
 * @date 07/02/2025
 */
public interface EstanteriaServices {
    Long create(Estanteria estanteria);         // Crear
    Optional<Estanteria> read(Long estanteriaId); // Leer
    void update(Estanteria estanteria);           // Actualizar
    void delete(Long estanteriaId);               // Borrar
    List<Estanteria> getAll();                    // Listar todos
}
