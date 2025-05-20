package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.ProfesorRequestDTO;
import com.unimag.espaciosum.dto.request.ReservaRequestDTO;
import com.unimag.espaciosum.dto.response.ProfesorResponseDTO;
import com.unimag.espaciosum.dto.response.ReservaResponseDTO;

import java.util.List;

public interface ReservaServicio {

    ReservaResponseDTO create(ReservaRequestDTO reservaRequestDTO);
    ReservaResponseDTO finbyId(Long id);
    List<ReservaResponseDTO> findAll();
    ReservaResponseDTO update(Long id,ReservaRequestDTO reservaRequestDTO);
    void delete(Long id);

    List<ReservaResponseDTO> reservasEstudiantes(Long estudianteId);
    List<ReservaResponseDTO> reservasProfesores(Long profesorId);
}
