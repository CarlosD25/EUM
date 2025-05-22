package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.HorarioRequestDTO;
import com.unimag.espaciosum.dto.response.HorarioResponseDTO;
import com.unimag.espaciosum.modelo.Espacio;
import com.unimag.espaciosum.modelo.Horario;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface HorarioMapper {


    @Mapping(source = "espacio.id",target ="idEspacio" )
    HorarioResponseDTO toDTO(Horario horario);


    @Mapping(target = "espacio",ignore = true)
    Horario toEntity(HorarioRequestDTO horarioRequestDTO);

}
