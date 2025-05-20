package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.EspacioRequestDTO;
import com.unimag.espaciosum.dto.request.EstudianteRequestDTO;
import com.unimag.espaciosum.dto.response.EspacioResponseDTO;
import com.unimag.espaciosum.dto.response.EstudianteResponseDTO;

import java.util.List;
import java.util.Optional;

public interface EspacioServicio {

    EspacioResponseDTO create(EspacioRequestDTO espacioRequestDTO);
    EspacioResponseDTO finbyId(Long id);
    List<EspacioResponseDTO> findAll();
    EspacioResponseDTO update(Long id, EspacioRequestDTO espacioRequestDTO);
    void delete(Long id);


    List<EspacioResponseDTO> filtrarPorTipo(String tipo);
    EspacioResponseDTO findByNombreIgnoreCase(String nombre);
}
