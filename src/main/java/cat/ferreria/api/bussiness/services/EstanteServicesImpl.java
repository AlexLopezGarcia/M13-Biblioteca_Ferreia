package cat.ferreria.api.bussiness.services;

import cat.ferreria.api.bussiness.model.clazz.Estante;
import cat.ferreria.api.bussiness.model.dtos.EstanteDTO;
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
    public EstanteDTO create(Estante estante) {
        Estante savedEstante = estanteRepository.save(estante);
        return EstanteDTO.EstanteMapper.toDTO(savedEstante);
    }

    @Override
    public Optional<Estante> read(Long id) {
        return estanteRepository.findById(id);
    }

    @Override
    public void update(Estante estante) {
        estanteRepository.save(estante);
    }

    @Override
    public void delete(Long id) {
        estanteRepository.deleteById(id);
    }

    @Override
    public List<Estante> getAll() {
        return estanteRepository.findAll();
    }
}