package cat.ferreria.api.presentation.restcontrollers;

import cat.ferreria.api.bussiness.model.Libro;
import cat.ferreria.api.bussiness.model.LibroDTO;
import cat.ferreria.api.bussiness.services.LibroServicesImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author alexl
 * @date 14/03/2025
 */
@RestController
@RequestMapping("/estante")
@Tag(name = "Estante", description = "Gestión de estantes")
public class EstanteController {

    @Autowired
    private EstanteServicesImpl estanteServices;
}
