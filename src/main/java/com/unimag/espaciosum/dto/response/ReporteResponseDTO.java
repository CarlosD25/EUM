package com.unimag.espaciosum.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteResponseDTO {
    private Long id;
    private String descripcion;
    private Long idConserje;
    private Long idEspacio;
}
