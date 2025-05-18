package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.ProfesorRequestDTO;
import com.unimag.espaciosum.dto.response.ProfesorResponseDTO;
import com.unimag.espaciosum.modelo.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    ProfesorResponseDTO toDTO(Profesor profesor);

    @Mapping(target = "reservas", ignore = true)
    Profesor toEntity(ProfesorRequestDTO profesorRequestDTO);
}
