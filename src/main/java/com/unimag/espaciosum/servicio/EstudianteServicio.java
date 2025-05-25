package com.unimag.espaciosum.servicio;

import com.unimag.espaciosum.dto.request.EstudianteRequestDTO;
import com.unimag.espaciosum.dto.request.LoginRequestDTO;
import com.unimag.espaciosum.dto.response.EstudianteResponseDTO;

import java.util.List;

public interface EstudianteServicio {

    EstudianteResponseDTO create(EstudianteRequestDTO estudianteRequestDTO);
    EstudianteResponseDTO finbyId(Long id);
    List<EstudianteResponseDTO> findAll();
    EstudianteResponseDTO update(Long id,EstudianteRequestDTO estudianteRequestDTO);
    void delete(Long id);

    EstudianteResponseDTO login(LoginRequestDTO loginRequestDTO);
    EstudianteResponseDTO buscarPorCodigoYContrasena(String codigo, String contrasena);
}
