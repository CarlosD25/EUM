package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.EstudianteRequestDTO;
import com.unimag.espaciosum.dto.request.HorarioRequestDTO;
import com.unimag.espaciosum.dto.response.EstudianteResponseDTO;
import com.unimag.espaciosum.dto.response.HorarioResponseDTO;

import java.util.List;

public interface HorarioServicio {

    HorarioResponseDTO create(HorarioRequestDTO horarioRequestDTO);
    HorarioResponseDTO finbyId(Long id);
    List<HorarioResponseDTO> findAll();
    HorarioResponseDTO update(Long id,HorarioRequestDTO horarioRequestDTO);
    void delete(Long id);

    List<HorarioResponseDTO> filtrarHorarioPorEspacio(Long espacioId);
    List<HorarioResponseDTO> filtrarHorariosSinReservaPorEspacio(Long espacioId);
}
