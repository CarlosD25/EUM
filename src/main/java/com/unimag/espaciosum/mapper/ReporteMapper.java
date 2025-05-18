package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.ReporteRequestDTO;
import com.unimag.espaciosum.dto.response.ReporteResponseDTO;
import com.unimag.espaciosum.modelo.Reporte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReporteMapper {

    @Mapping(source = "conserje.id",target ="idConserje" )
    @Mapping(source = "espacio.id",target = "idEspacio")
    ReporteResponseDTO toDTO(Reporte reporte);

    @Mapping(target = "espacio", ignore = true)
    @Mapping(target = "conserje", ignore = true)
    Reporte toEntity(ReporteRequestDTO reporteRequestDTO);
}
