package com.unimag.espaciosum.controlador;

import com.unimag.espaciosum.dto.request.EstudianteRequestDTO;
import com.unimag.espaciosum.dto.response.EstudianteResponseDTO;
import com.unimag.espaciosum.servicio.EstudianteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estudiantes")
@RequiredArgsConstructor
public class EstudianteControlador {

    private final EstudianteServicio estudianteServicio;

    @PostMapping
    public EstudianteResponseDTO crearEstudiante(EstudianteRequestDTO estudianteRequestDTO) {
        return estudianteServicio.create(estudianteRequestDTO);
    }

    @GetMapping
    public List<EstudianteResponseDTO> todosLosEstudiantes() {
        return estudianteServicio.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteResponseDTO estudianteId(@PathVariable Long id) {
        return estudianteServicio.finbyId(id);
    }

    @PutMapping("/{id}")
    public EstudianteResponseDTO actualizarEstudiante(@PathVariable Long id, EstudianteRequestDTO estudianteRequestDTO) {
        return estudianteServicio.update(id,estudianteRequestDTO );
    }

    @DeleteMapping("/{id}")
    public void borrarEstudiante(@PathVariable Long id) {
        estudianteServicio.delete(id);
    }
}
