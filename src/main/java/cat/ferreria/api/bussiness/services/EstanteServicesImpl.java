package cat.ferreria.api.bussiness.services;

import cat.ferreria.api.bussiness.model.Estante;
import cat.ferreria.api.bussiness.repository.EstanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author alexl
 * @date 14/03/2025
 */
@Service
public class EstanteServicesImpl implements EstanteServices {
    private final EstanteRepository estanteRepository;

    @Autowired
    public EstanteServicesImpl(EstanteRepository estanteRepository) {
        this.estanteRepository = estanteRepository;
    }

    @Override
    public String create(Estante estante) {
        return estanteRepository.save(estante).getEstante_id();
    }

    @Override
    public Optional<Estante> read(String id) {
        return Optional.empty();
    }

    @Override
    public void update(Estante estante) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<Estante> getAll() {
        return List.of();
    }
}
