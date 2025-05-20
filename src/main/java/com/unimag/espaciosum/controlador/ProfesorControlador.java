package com.unimag.espaciosum.controlador;

import com.unimag.espaciosum.dto.request.ProfesorRequestDTO;
import com.unimag.espaciosum.dto.response.ProfesorResponseDTO;
import com.unimag.espaciosum.servicio.ProfesorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profesores")
@RequiredArgsConstructor
public class ProfesorControlador {

    private final ProfesorServicio profesorServicio;

    @PostMapping
    public ProfesorResponseDTO crearProfesor(ProfesorRequestDTO profesorRequestDTO) {
        return profesorServicio.create(profesorRequestDTO);
    }

    @GetMapping
    public List<ProfesorResponseDTO> todosLosProfesores() {
        return profesorServicio.findAll();
    }

    @GetMapping("/{id}")
    public ProfesorResponseDTO profesorId( @PathVariable Long id) {
        return profesorServicio.finbyId(id);
    }

    @PutMapping("/{id}")
    public ProfesorResponseDTO actualizarProfesor( @PathVariable Long id, ProfesorRequestDTO profesorRequestDTO) {
        return profesorServicio.update(id,profesorRequestDTO );
    }

    @DeleteMapping("/{id}")
    public void borrarProfesor(@PathVariable Long id) {
        profesorServicio.delete(id);
    }
}
