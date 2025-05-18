package com.unimag.espaciosum.dto.response;

import lombok.*;

import java.util.List;

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
