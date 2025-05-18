package com.unimag.espaciosum.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaRequestDTO {
    private Long idEstudiante;
    private Long idProfesor;
    private Long idEspacio;
    private Long idHorario;
}
