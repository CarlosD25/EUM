package com.unimag.espaciosum.mapper;

import com.unimag.espaciosum.dto.request.ReservaRequestDTO;
import com.unimag.espaciosum.dto.response.ReservaResponseDTO;
import com.unimag.espaciosum.modelo.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(source = "estudiante.id",target = "idEstudiante")
    @Mapping(source = "espacio.id",target = "idEspacio")
    @Mapping(source = "profesor.id",target = "idProfesor")
    @Mapping(source = "horario.id",target = "idHorario")
    ReservaResponseDTO toDTO(Reserva reserva);

    @Mapping(target = "espacio", ignore = true)
    @Mapping(target = "estudiante", ignore = true)
    @Mapping(target = "profesor",ignore = true)
    @Mapping(target = "horario",ignore = true)
    Reserva toEntity(ReservaRequestDTO reservaRequestDTO);
}
