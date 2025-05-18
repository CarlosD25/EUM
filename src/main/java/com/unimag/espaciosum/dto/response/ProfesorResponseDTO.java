package com.unimag.espaciosum.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesorResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private String identificacion;

}
