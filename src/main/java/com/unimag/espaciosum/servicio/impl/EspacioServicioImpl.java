package com.unimag.espaciosum.servicio.impl;

import com.unimag.espaciosum.dto.request.EspacioRequestDTO;
import com.unimag.espaciosum.dto.response.EspacioResponseDTO;
import com.unimag.espaciosum.mapper.EspacioMapper;
import com.unimag.espaciosum.modelo.Espacio;
import com.unimag.espaciosum.repositorio.EspacioRepositorio;
import com.unimag.espaciosum.servicio.EspacioServicio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EspacioServicioImpl implements EspacioServicio {

    private final EspacioRepositorio espacioRepositorio;
    private final EspacioMapper espacioMapper;

    @Override
    public EspacioResponseDTO create(EspacioRequestDTO espacioRequestDTO) {
        Espacio espacio = espacioMapper.toEntity(espacioRequestDTO);
        return espacioMapper.toDTO(espacioRepositorio.save(espacio));
    }

    @Override
    public EspacioResponseDTO finbyId(Long id) {
        return espacioRepositorio.findById(id).map(espacio -> espacioMapper.toDTO(espacio)).orElseThrow(()->new EntityNotFoundException("Espacio con id "+id+" no encontrado"));
    }

    @Override
    public List<EspacioResponseDTO> findAll() {
        return espacioRepositorio.findAll().stream().map(espacioMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EspacioResponseDTO update(Long id, EspacioRequestDTO espacioRequestDTO) {
        Espacio espacio = espacioRepositorio.findById(id).orElseThrow(()->new EntityNotFoundException("Espacio no encontrado"));
        espacio.setNombre(espacioRequestDTO.getNombre());
        espacio.setCapacidad(espacioRequestDTO.getCapacidad());
        espacio.setTipo(espacioRequestDTO.getTipo());
        return espacioMapper.toDTO(espacioRepositorio.save(espacio));
    }

    @Override
    public void delete(Long id) {
        if(!espacioRepositorio.existsById(id)){
            throw new EntityNotFoundException("Espacio no encontrado");
        }
        espacioRepositorio.deleteById(id);
    }

    @Override
    public List<EspacioResponseDTO> filtrarPorTipo(String tipo) {
        return espacioRepositorio.findByTipo(tipo)
                .stream()
                .map(espacioMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public EspacioResponseDTO findByNombreIgnoreCase(String nombre) {
        return espacioRepositorio.findByNombreIgnoreCase(nombre)
                .map(espacioMapper::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Espacio no encontrado con nombre: " + nombre));
    }
}
