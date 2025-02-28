package cat.ferreria.api.bussiness.services;

import cat.ferreria.api.bussiness.model.Estanteria;
import java.util.List;
import java.util.Optional;

public interface EstanteriaServices {
    int create(Estanteria estanteria);
    Optional<Estanteria> read(int id);
    void update(Estanteria estanteria);
    void delete(int id);
    List<Estanteria> getAll();
}
