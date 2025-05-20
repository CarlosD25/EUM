package com.unimag.espaciosum.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HorarioResponseDTO {
    private Long id;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private Long idEspacio;
}
