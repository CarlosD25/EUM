package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.HorarioRequestDTO;
import com.unimag.espaciosum.dto.response.HorarioResponseDTO;
import com.unimag.espaciosum.modelo.Horario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HorarioMapper {

    HorarioResponseDTO toDTO(Horario horario);
    Horario toEntity(HorarioRequestDTO horarioRequestDTO);
}
