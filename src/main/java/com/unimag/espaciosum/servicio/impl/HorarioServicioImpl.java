package com.unimag.espaciosum.servicio.impl;

import com.unimag.espaciosum.dto.request.HorarioRequestDTO;
import com.unimag.espaciosum.dto.response.HorarioResponseDTO;
import com.unimag.espaciosum.mapper.HorarioMapper;
import com.unimag.espaciosum.modelo.Espacio;
import com.unimag.espaciosum.modelo.Horario;
import com.unimag.espaciosum.repositorio.EspacioRepositorio;
import com.unimag.espaciosum.repositorio.HorarioRepositorio;
import com.unimag.espaciosum.repositorio.ReservaRepositorio;
import com.unimag.espaciosum.servicio.HorarioServicio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HorarioServicioImpl implements HorarioServicio {

    private final HorarioRepositorio horarioRepositorio;
    private final HorarioMapper horarioMapper;
    private final EspacioRepositorio espacioRepositorio;
    private final ReservaRepositorio reservaRepositorio;


    @Override
    public HorarioResponseDTO create(HorarioRequestDTO horarioRequestDTO) {
        Horario horario = horarioMapper.toEntity(horarioRequestDTO);
        if(horarioRequestDTO.getIdEspacio()!=null){
            Espacio espacio = new Espacio();
            espacio.setId(horarioRequestDTO.getIdEspacio());
            horario.setEspacio(espacio);
        }
        return horarioMapper.toDTO(horarioRepositorio.save(horario));
    }

    @Override
    public HorarioResponseDTO finbyId(Long id) {
        return horarioRepositorio.findById(id).map(horarioMapper::toDTO).orElseThrow(() -> new EntityNotFoundException("No se encontró el horario"));
    }

    @Override
    public List<HorarioResponseDTO> findAll() {
        return horarioRepositorio.findAll().stream().map(horarioMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public HorarioResponseDTO update(Long id, HorarioRequestDTO horarioRequestDTO) {
        Horario horario = horarioRepositorio.findById(id).orElseThrow(()->new EntityNotFoundException("No se encontró el horario"));
        Optional<Espacio> espacio = espacioRepositorio.findById(horarioRequestDTO.getIdEspacio());
        horario.setHoraInicio(horarioRequestDTO.getHoraInicio());
        horario.setHoraFin(horarioRequestDTO.getHoraFin());
        horario.setEspacio(espacio.get());
        return horarioMapper.toDTO(horarioRepositorio.save(horario));
    }

    @Override
    public void delete(Long id) {

        if(!horarioRepositorio.existsById(id)){
            throw new EntityNotFoundException("No se encuentra el horario");
        }
        horarioRepositorio.deleteById(id);

    }

    @Override
    public List<HorarioResponseDTO> filtrarHorarioPorEspacio(Long espacioId) {
        return horarioRepositorio.filtrarHorarioPorEspacio(espacioId).stream().map(horarioMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<HorarioResponseDTO> filtrarHorariosSinReservaPorEspacio(Long espacioId) {
        return horarioRepositorio.filtrarHorariosSinReservaPorEspacio(espacioId).stream().map(horarioMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<HorarioResponseDTO> filtrarHorariosPorEspacioDia(Long espacioId, String dia) {
        DayOfWeek diaS = DayOfWeek.valueOf(dia.toUpperCase());

        return horarioRepositorio.filtrarHorarioPorEspacio(espacioId).stream()
                .filter(h -> h.getHoraInicio().getDayOfWeek().equals(diaS))
                .filter(h -> !reservaRepositorio.existsByHorarioId(h.getId())) 
                .map(horarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
