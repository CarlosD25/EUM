package com.unimag.espaciosum.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfesorRequestDTO {
    @NotBlank
    private String nombre;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String identificacion;
}
