package cat.ferreria.api.bussiness.services.interfaces;

import cat.ferreria.api.bussiness.model.clazz.Historial;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para los servicios de gestión del historial de préstamos.
 *
 * @author alexl
 * @date 07/02/2025
 */
public interface HistorialServices {
    Long create(Historial historial);
    Optional<Historial> read(Long historialId);
    void update(Historial historial);
    void delete(Long historialId);
    List<Historial> getAll();
}