package com.unimag.espaciosum.servicio.impl;

import com.unimag.espaciosum.dto.request.ReservaRequestDTO;
import com.unimag.espaciosum.dto.response.ReservaResponseDTO;
import com.unimag.espaciosum.mapper.ReservaMapper;
import com.unimag.espaciosum.modelo.*;
import com.unimag.espaciosum.repositorio.*;
import com.unimag.espaciosum.servicio.ReservaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaServicioImpl implements ReservaServicio {

    private final ReservaRepositorio reservaRepositorio;
    private final ReservaMapper reservaMapper;
    private final ProfesorRepositorio profesorRepositorio;
    private final HorarioRepositorio horarioRepositorio;
    private final EspacioRepositorio espacioRepositorio;
    private final EstudianteRepositorio estudianteRepositorio;

    @Override
    public ReservaResponseDTO create(ReservaRequestDTO reservaRequestDTO) {
        Reserva reserva = reservaMapper.toEntity(reservaRequestDTO);

        if(reservaRequestDTO.getIdProfesor() != null) {
            Profesor profesor = new Profesor();
            profesor.setId(reservaRequestDTO.getIdProfesor());
            reserva.setProfesor(profesor);
        }
        if(reservaRequestDTO.getIdEstudiante() != null) {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(reservaRequestDTO.getIdEstudiante());
            reserva.setEstudiante(estudiante);
        }
        Espacio espacio = new Espacio();
        espacio.setId(reservaRequestDTO.getIdEspacio());

        Horario horario = new Horario();
        horario.setId(reservaRequestDTO.getIdHorario());

        reserva.setEspacio(espacio);
        reserva.setHorario(horario);
        return reservaMapper.toDTO(reservaRepositorio.save(reserva));
    }

    @Override
    public ReservaResponseDTO finbyId(Long id) {
        return reservaRepositorio.findById(id).map(reserva -> reservaMapper.toDTO(reserva)).orElseThrow(() -> new RuntimeException("No se encontro el reserva"));
    }

    @Override
    public List<ReservaResponseDTO> findAll() {
        return reservaRepositorio.findAll().stream().map(reservaMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ReservaResponseDTO update(Long id, ReservaRequestDTO reservaRequestDTO) {
        Reserva reserva = reservaRepositorio.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el reserva"));
        Estudiante estudiante = estudianteRepositorio.findById(reservaRequestDTO.getIdEstudiante()).get();
        Profesor profesor = profesorRepositorio.findById(reservaRequestDTO.getIdProfesor()).get();
        Espacio espacio = espacioRepositorio.findById(reservaRequestDTO.getIdEspacio()).get();
        Horario horario = horarioRepositorio.findById(reservaRequestDTO.getIdHorario()).get();

        reserva.setEspacio(espacio);
        reserva.setProfesor(profesor);
        reserva.setEstudiante(estudiante);
        reserva.setHorario(horario);
        return reservaMapper.toDTO(reservaRepositorio.save(reserva));
    }

    @Override
    public void delete(Long id) {
        if(!reservaRepositorio.existsById(id)){
            throw new RuntimeException("No se encontro el reserva");
        }
        reservaRepositorio.deleteById(id);
    }

    @Override
    public List<ReservaResponseDTO> reservasEstudiantes(Long estudianteId) {
        return reservaRepositorio.reservasEstudianteId(estudianteId).stream().map(reservaMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReservaResponseDTO> reservasProfesores(Long profesorId) {
        return reservaRepositorio.reservasProfesorId(profesorId).stream().map(reservaMapper::toDTO).collect(Collectors.toList());
    }




}
