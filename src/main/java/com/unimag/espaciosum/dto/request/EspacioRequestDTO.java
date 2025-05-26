package com.unimag.espaciosum.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspacioRequestDTO {

    @NotBlank
    private String nombre;
    private Integer capacidad;
    private String tipo;

}
