package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.EspacioRequestDTO;
import com.unimag.espaciosum.dto.response.EspacioResponseDTO;

import java.util.List;

public interface EspacioServicio {

    EspacioResponseDTO create(EspacioRequestDTO espacioRequestDTO);
    EspacioResponseDTO finbyId(Long id);
    List<EspacioResponseDTO> findAll();
    EspacioResponseDTO update(Long id, EspacioRequestDTO espacioRequestDTO);
    void delete(Long id);


    List<EspacioResponseDTO> filtrarPorTipo(String tipo);
    EspacioResponseDTO findByNombreIgnoreCase(String nombre);
}
