package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.EspacioRequestDTO;
import com.unimag.espaciosum.dto.response.EspacioResponseDTO;
import com.unimag.espaciosum.modelo.Espacio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EspacioMapper {

    EspacioResponseDTO toDTO(Espacio espacio);

    @Mapping(target = "horarios",ignore = true)
    @Mapping(target = "reportes",ignore = true)
    Espacio toEntity(EspacioRequestDTO espacioRequestDTO);
}
