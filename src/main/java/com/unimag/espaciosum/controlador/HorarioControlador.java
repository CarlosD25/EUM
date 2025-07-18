package com.unimag.espaciosum.controlador;


import com.unimag.espaciosum.dto.request.HorarioRequestDTO;
import com.unimag.espaciosum.dto.response.HorarioResponseDTO;
import com.unimag.espaciosum.servicio.HorarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/horarios")
@RequiredArgsConstructor
public class HorarioControlador {

    private final HorarioServicio horarioServicio;


    @PostMapping
    public HorarioResponseDTO crearHorario(@RequestBody HorarioRequestDTO horarioRequestDTO) {
        return horarioServicio.create(horarioRequestDTO);
    }

    @GetMapping
    public List<HorarioResponseDTO> todosLosHorarios() {
        return horarioServicio.findAll();
    }

    @GetMapping("/{id}")
    public HorarioResponseDTO horarioId(@PathVariable Long id) {
        return horarioServicio.finbyId(id);
    }

    @PutMapping("/{id}")
    public HorarioResponseDTO actualizarHorario(@PathVariable Long id,@RequestBody HorarioRequestDTO horarioRequestDTO) {
        return horarioServicio.update(id,horarioRequestDTO );
    }

    @DeleteMapping("/{id}")
    public void borrarHorario(@PathVariable Long id) {
        horarioServicio.delete(id);
    }

    @GetMapping("/espacio/{id}")
    public List<HorarioResponseDTO> espacioId(@PathVariable Long id) {
        return horarioServicio.filtrarHorarioPorEspacio(id);
    }
    @GetMapping("/espacio/{id}/no-reservado")
    public List<HorarioResponseDTO> espacioIdNoReservado(@PathVariable Long id) {
        return horarioServicio.filtrarHorariosSinReservaPorEspacio(id);
    }

    @GetMapping("/espacio/{espacioId}/dia/{dia}")
    public List<HorarioResponseDTO> obtenerHorariosPorEspacioYDia(@PathVariable Long espacioId, @PathVariable String dia) {
        return horarioServicio.filtrarHorariosPorEspacioDia(espacioId, dia);
    }
}
