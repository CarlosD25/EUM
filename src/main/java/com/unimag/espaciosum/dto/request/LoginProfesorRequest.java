package com.unimag.espaciosum.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginProfesorRequest {

    private String email;
    private String password;
}
