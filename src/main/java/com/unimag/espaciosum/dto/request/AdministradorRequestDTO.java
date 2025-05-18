package com.unimag.espaciosum.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdministradorRequestDTO {
    private String nombre;
    private String email;
    private String password;
    private String identificacion;
}
