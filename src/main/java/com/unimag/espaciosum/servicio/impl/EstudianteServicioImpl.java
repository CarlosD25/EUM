package com.unimag.espaciosum.servicio.impl;

import com.unimag.espaciosum.dto.request.EstudianteRequestDTO;
import com.unimag.espaciosum.dto.response.EstudianteResponseDTO;
import com.unimag.espaciosum.mapper.EstudianteMapper;
import com.unimag.espaciosum.modelo.Estudiante;
import com.unimag.espaciosum.repositorio.EstudianteRepositorio;
import com.unimag.espaciosum.servicio.EstudianteServicio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EstudianteServicioImpl implements EstudianteServicio {

    private final EstudianteRepositorio estudianteRepositorio;
    private final EstudianteMapper estudianteMapper;


    @Override
    public EstudianteResponseDTO create(EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = estudianteMapper.toEntity(estudianteRequestDTO);
        return estudianteMapper.toDTO(estudianteRepositorio.save(estudiante));
    }

    @Override
    public EstudianteResponseDTO finbyId(Long id) {
        return estudianteRepositorio.findById(id).map(estudiante -> estudianteMapper.toDTO(estudiante)).orElseThrow(()->new EntityNotFoundException("Estudiante no encontrado"));
    }

    @Override
    public List<EstudianteResponseDTO> findAll() {
        return estudianteRepositorio.findAll().stream().map(estudianteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EstudianteResponseDTO update(Long id, EstudianteRequestDTO estudianteRequestDTO) {
        Estudiante estudiante = estudianteRepositorio.findById(id).orElseThrow(()->new EntityNotFoundException("Estudiante no encontrado"));
        estudiante.setNombre(estudianteRequestDTO.getNombre());
        estudiante.setEmail(estudianteRequestDTO.getEmail());
        estudiante.setCodigo(estudianteRequestDTO.getCodigo());
        estudiante.setPassword(estudianteRequestDTO.getPassword());
        estudiante.setIdentificacion(estudianteRequestDTO.getIdentificacion());
        return estudianteMapper.toDTO(estudianteRepositorio.save(estudiante));
    }

    @Override
    public void delete(Long id) {
        if(!estudianteRepositorio.existsById(id)) {
            throw new EntityNotFoundException("Estudiante no encontrado");
        }
        estudianteRepositorio.deleteById(id);
    }

    @Override
    public EstudianteResponseDTO login(String codigo, String password) {
        return null;
    }

    @Override
    public EstudianteResponseDTO buscarPorCodigoYContrasena(String codigo, String contrasena) {
        return estudianteRepositorio
                .buscarPorCodigoYContrasena(codigo, contrasena)
                .map(estudianteMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }
}
