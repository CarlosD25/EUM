package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.ConserjeRequestDTO;
import com.unimag.espaciosum.dto.request.LoginConserjeRequestDTO;
import com.unimag.espaciosum.dto.response.ConserjeResponseDTO;

import java.util.List;

public interface ConserjeServicio {

    ConserjeResponseDTO create(ConserjeRequestDTO conserjeRequestDTO);
    ConserjeResponseDTO finbyId(Long id);
    List<ConserjeResponseDTO> findAll();
    ConserjeResponseDTO update(Long id,ConserjeRequestDTO conserjeRequestDTO);
    void delete(Long id);
    ConserjeResponseDTO login(LoginConserjeRequestDTO loginConserjeRequestDTO);

}
