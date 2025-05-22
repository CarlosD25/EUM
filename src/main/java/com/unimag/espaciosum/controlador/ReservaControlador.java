package com.unimag.espaciosum.controlador;

import com.unimag.espaciosum.dto.request.ReservaRequestDTO;
import com.unimag.espaciosum.dto.response.ReservaResponseDTO;
import com.unimag.espaciosum.servicio.ReservaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reservas")
@RequiredArgsConstructor
public class ReservaControlador {

    private final ReservaServicio reservaServicio;

    @PostMapping
    public ReservaResponseDTO crearReserva(@RequestBody ReservaRequestDTO reservaRequestDTO) {
        return reservaServicio.create(reservaRequestDTO);
    }

    @GetMapping
    public List<ReservaResponseDTO> todosLasReservas() {
        return reservaServicio.findAll();
    }

    @GetMapping("/{id}")
    public ReservaResponseDTO reservaId( @PathVariable Long id) {
        return reservaServicio.finbyId(id);
    }

    @PutMapping("/{id}")
    public ReservaResponseDTO actualizarReserva( @PathVariable Long id,@RequestBody ReservaRequestDTO reservaRequestDTO) {
        return reservaServicio.update(id,reservaRequestDTO );
    }

    @DeleteMapping("/{id}")
    public void borrarReserva(@PathVariable Long id) {
        reservaServicio.delete(id);
    }

    @GetMapping("/estudiante/{id}")
    public List<ReservaResponseDTO> estudianteId(@PathVariable Long id) {
        return reservaServicio.reservasEstudiantes(id);
    }
    @GetMapping("/profesor/{id}")
    public List<ReservaResponseDTO> profesorId(@PathVariable Long id) {
        return reservaServicio.reservasProfesores(id);
    }
}
