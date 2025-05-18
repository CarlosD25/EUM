package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.EstudianteRequestDTO;
import com.unimag.espaciosum.dto.response.EstudianteResponseDTO;
import com.unimag.espaciosum.modelo.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    EstudianteResponseDTO toDTO(Estudiante estudiante);

    @Mapping(target = "reservas",ignore = true)
    Estudiante toEntity(EstudianteRequestDTO estudianteRequestDTO);
}
