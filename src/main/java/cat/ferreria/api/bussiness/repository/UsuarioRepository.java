package cat.ferreria.api.bussiness.repository;
/**
 * @author Ruben
 * @date 18/02/2025
 */
import cat.ferreria.api.bussiness.model.clazz.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query("SELECT u FROM Usuario u WHERE u.correoElectronico = :correoElectronico AND u.contrasenya = :contrasenya")
    Optional<Usuario> findByCorreoElectronicoAndContrasenya(@Param("correoElectronico") String correoElectronico,
                                                            @Param("contrasenya") String contrasenya);
}
