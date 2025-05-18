package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.ConserjeRequestDTO;
import com.unimag.espaciosum.dto.response.ConserjeResponseDTO;
import com.unimag.espaciosum.modelo.Conserje;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConserjeMapper {


    ConserjeResponseDTO toDTO(Conserje conserje);

    @Mapping(target = "reportes",ignore = true)
    Conserje toEntity(ConserjeRequestDTO conserjeRequestDTO);
}
