package com.unimag.espaciosum.servicio.impl;

import com.unimag.espaciosum.dto.request.ReporteRequestDTO;
import com.unimag.espaciosum.dto.response.ReporteResponseDTO;
import com.unimag.espaciosum.mapper.ReporteMapper;
import com.unimag.espaciosum.modelo.Conserje;
import com.unimag.espaciosum.modelo.Espacio;
import com.unimag.espaciosum.modelo.Reporte;
import com.unimag.espaciosum.repositorio.ConserjeRepositorio;
import com.unimag.espaciosum.repositorio.EspacioRepositorio;
import com.unimag.espaciosum.repositorio.ReporteRepositorio;
import com.unimag.espaciosum.servicio.ReporteServicio;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReporteServicioImpl implements ReporteServicio {

    private final ReporteRepositorio reporteRepositorio;
    private final ReporteMapper reporteMapper;
    private final ConserjeRepositorio conserjeRepositorio;
    private final EspacioRepositorio espacioRepositorio;

    @Override
    public ReporteResponseDTO create(ReporteRequestDTO reporteRequestDTO) {
        Reporte reporte = reporteMapper.toEntity(reporteRequestDTO);
        Conserje conserje = conserjeRepositorio.findById(reporteRequestDTO.getIdConserje()).orElseThrow(()->new EntityNotFoundException("No se encontro el id"));
        Espacio espacio = espacioRepositorio.findById(reporteRequestDTO.getIdEspacio()).orElseThrow(() -> new EntityNotFoundException("Espacio no encontrado"));
        reporte.setConserje(conserje);
        reporte.setEspacio(espacio);
        return reporteMapper.toDTO(reporteRepositorio.save(reporte));
    }

    @Override
    public ReporteResponseDTO finbyId(Long id) {
        return reporteRepositorio.findById(id).map(reporteMapper::toDTO).orElseThrow(()->new RuntimeException("No se encontro el reporte con id: " + id));
    }

    @Override
    public List<ReporteResponseDTO> findAll() {
        return reporteRepositorio.findAll().stream().map(reporteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ReporteResponseDTO update(Long id, ReporteRequestDTO reporteRequestDTO) {
        Reporte reporte = reporteRepositorio.findById(id).orElseThrow(()->new RuntimeException("No se encontro el reporte con id: " + id));
        Espacio espacio =espacioRepositorio.findById(reporteRequestDTO.getIdEspacio()).get();
        Conserje conserje = conserjeRepositorio.findById(reporteRequestDTO.getIdConserje()).get();

        reporte.setDescripcion(reporteRequestDTO.getDescripcion());
        reporte.setConserje(conserje);
        reporte.setEspacio(espacio);
        return reporteMapper.toDTO(reporteRepositorio.save(reporte));
    }

    @Override
    public List<ReporteResponseDTO> reportesPorIdEspacio(Long id) {
        return reporteRepositorio.findAll().stream().map(reporteMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if(!reporteRepositorio.existsById(id)) {
            throw new EntityNotFoundException("No se encontro el reporte con id: " + id);
        }
        reporteRepositorio.deleteById(id);
    }



}
