package com.unimag.espaciosum.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HorarioRequestDTO {
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private Long idEspacio;
}
