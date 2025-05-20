package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.HorarioRequestDTO;
import com.unimag.espaciosum.dto.response.HorarioResponseDTO;
import com.unimag.espaciosum.modelo.Horario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HorarioMapper {

    @Mapping(source = "espacio.id",target ="idEspacio" )
    HorarioResponseDTO toDTO(Horario horario);
    Horario toEntity(HorarioRequestDTO horarioRequestDTO);
}
