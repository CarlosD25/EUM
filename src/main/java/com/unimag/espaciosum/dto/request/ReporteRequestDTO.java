package com.unimag.espaciosum.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteRequestDTO {
    private String descripcion;
    private Long idConserje;
    private Long idEspacio;
}
