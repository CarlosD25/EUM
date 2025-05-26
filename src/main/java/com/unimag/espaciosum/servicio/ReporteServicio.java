package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.ReporteRequestDTO;
import com.unimag.espaciosum.dto.response.ReporteResponseDTO;

import java.util.List;

public interface ReporteServicio {
    ReporteResponseDTO create(ReporteRequestDTO reporteRequestDTO);
    ReporteResponseDTO finbyId(Long id);
    List<ReporteResponseDTO> findAll();
    ReporteResponseDTO update(Long id,ReporteRequestDTO reporteRequestDTO);
    void delete(Long id);
}
