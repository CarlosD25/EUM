package com.unimag.espaciosum.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspacioRequestDTO {
    private String nombre;
    private Integer capacidad;
    private String tipo;

}
