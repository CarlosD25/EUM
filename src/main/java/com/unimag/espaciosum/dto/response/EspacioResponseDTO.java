package com.unimag.espaciosum.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspacioResponseDTO {
    private Long id;
    private String nombre;
    private Integer capacidad;
    private String tipo;
}
