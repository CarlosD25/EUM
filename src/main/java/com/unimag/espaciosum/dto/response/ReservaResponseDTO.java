package com.unimag.espaciosum.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaResponseDTO {
    private Long id;
    private Long idEstudiante;
    private Long idProfesor;
    private Long idEspacio;
    private Long idHorario;
}
