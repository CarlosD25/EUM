package com.unimag.espaciosum.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginProfesorRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
