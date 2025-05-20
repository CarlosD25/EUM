package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.ConserjeRequestDTO;
import com.unimag.espaciosum.dto.request.EstudianteRequestDTO;
import com.unimag.espaciosum.dto.response.ConserjeResponseDTO;
import com.unimag.espaciosum.dto.response.EstudianteResponseDTO;

import java.util.List;

public interface ConserjeServicio {

    ConserjeResponseDTO create(ConserjeRequestDTO conserjeRequestDTO);
    ConserjeResponseDTO finbyId(Long id);
    List<ConserjeResponseDTO> findAll();
    ConserjeResponseDTO update(Long id,ConserjeRequestDTO conserjeRequestDTO);
    void delete(Long id);

}
