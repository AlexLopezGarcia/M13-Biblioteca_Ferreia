package cat.ferreria.api.bussiness.services.impls;

import cat.ferreria.api.bussiness.model.clazz.Estanteria;
import cat.ferreria.api.bussiness.repository.EstanteriaRepository;
import cat.ferreria.api.bussiness.services.interfaces.EstanteriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación de los servicios para la entidad Estanteria.
 *
 * @author oriol
 * @date 07/02/2025
 */
@Service
public class EstanteriaServicesImpl implements EstanteriaServices {

    private final EstanteriaRepository estanteriaRepository;

    @Autowired
    public EstanteriaServicesImpl(EstanteriaRepository estanteriaRepository) {
        this.estanteriaRepository = estanteriaRepository;
    }

    @Override
    public Long create(Estanteria estanteria) {
        return estanteriaRepository.save(estanteria).getEstanteriaId();
    }

    @Override
    public Optional<Estanteria> read(Long estanteriaId) {
        return estanteriaRepository.findById(estanteriaId);
    }

    @Override
    public void update(Estanteria estanteria) {
        estanteriaRepository.save(estanteria);
    }

    @Override
    public void delete(Long estanteriaId) {
        estanteriaRepository.deleteById(estanteriaId);
    }

    @Override
    public List<Estanteria> getAll() {
        return estanteriaRepository.findAll();
    }
}
