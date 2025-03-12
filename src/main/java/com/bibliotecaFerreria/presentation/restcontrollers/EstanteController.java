package com.bibliotecaFerreria.presentation.restcontrollers;

import com.bibliotecaFerreria.bussiness.model.EstanteDTO;
import com.bibliotecaFerreria.bussiness.services.EstanteServicesImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author alexh
 * @date 12/03/2025
 */

@RestController
@RequestMapping("/estante")
@Tag(name = "Estantes", description = "Gestión de estantes")
public class EstanteController {
    @Autowired
    private EstanteServicesImpl estanteServices;

    @GetMapping
    public ResponseEntity<ArrayList<EstanteDTO>> getAll(){
        List<EstanteDTO> estanteDTOS = estanteServices.getEstantes().stream()
                .map(EstanteDTO.EstanteMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new ArrayList<EstanteDTO>(estanteDTOS));
    }
}
