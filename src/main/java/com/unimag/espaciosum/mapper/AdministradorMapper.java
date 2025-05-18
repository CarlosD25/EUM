package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.AdministradorRequestDTO;
import com.unimag.espaciosum.dto.response.AdministradorResponseDTO;
import com.unimag.espaciosum.modelo.Administrador;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdministradorMapper {

    AdministradorResponseDTO toDTO(Administrador administrador);

    Administrador toEntity(AdministradorRequestDTO administradorRequestDTO);
}
