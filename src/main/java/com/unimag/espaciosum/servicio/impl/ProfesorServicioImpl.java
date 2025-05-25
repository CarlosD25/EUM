package com.unimag.espaciosum.servicio.impl;

import com.unimag.espaciosum.dto.request.LoginProfesorRequest;
import com.unimag.espaciosum.dto.request.ProfesorRequestDTO;
import com.unimag.espaciosum.dto.response.ProfesorResponseDTO;
import com.unimag.espaciosum.mapper.ProfesorMapper;
import com.unimag.espaciosum.modelo.Profesor;
import com.unimag.espaciosum.repositorio.ProfesorRepositorio;
import com.unimag.espaciosum.servicio.ProfesorServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfesorServicioImpl implements ProfesorServicio {

    private final ProfesorRepositorio profesorRepositorio;
    private final ProfesorMapper profesorMapper;

    @Override
    public ProfesorResponseDTO create(ProfesorRequestDTO profesorRequestDTO) {
        Profesor profesor = profesorMapper.toEntity(profesorRequestDTO);
        return profesorMapper.toDTO(profesorRepositorio.save(profesor));
    }

    @Override
    public ProfesorResponseDTO finbyId(Long id) {
        return profesorRepositorio.findById(id).map(profesorMapper::toDTO).orElseThrow(()->new RuntimeException("El profesor no existe"));
    }

    @Override
    public List<ProfesorResponseDTO> findAll() {
        return profesorRepositorio.findAll().stream().map(profesorMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ProfesorResponseDTO update(Long id, ProfesorRequestDTO profesorRequestDTO) {
        Profesor profesor = profesorRepositorio.findById(id).orElseThrow(()->new RuntimeException("El profesor no existe"));
        profesor.setNombre(profesorRequestDTO.getNombre());
        profesor.setEmail(profesorRequestDTO.getEmail());
        profesor.setPassword(profesorRequestDTO.getPassword());
        profesor.setIdentificacion(profesorRequestDTO.getIdentificacion());
        return profesorMapper.toDTO(profesorRepositorio.save(profesor));
    }

    @Override
    public void delete(Long id) {
        if(!profesorRepositorio.existsById(id)){
            throw new RuntimeException("El profesor no existe");
        }
        profesorRepositorio.deleteById(id);
    }

    @Override
    public ProfesorResponseDTO login(LoginProfesorRequest loginProfesorRequest) {
        String email = loginProfesorRequest.getEmail();
        String password = loginProfesorRequest.getPassword();
        Optional<Profesor> profesor = profesorRepositorio.buscarPorEmailYPassword(email, password);
        if(profesor.isPresent()){
            return profesorMapper.toDTO(profesor.get());
        }
        throw new RuntimeException("No se encontro un profesor con email "+email);
    }
}
