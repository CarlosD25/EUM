package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.ProfesorRequestDTO;
import com.unimag.espaciosum.dto.response.ProfesorResponseDTO;

import java.util.List;

public interface ProfesorServicio {

    ProfesorResponseDTO create(ProfesorRequestDTO profesorRequestDTO);
    ProfesorResponseDTO finbyId(Long id);
    List<ProfesorResponseDTO> findAll();
    ProfesorResponseDTO update(Long id,ProfesorRequestDTO profesorRequestDTO);
    void delete(Long id);
}
