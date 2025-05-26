package com.unimag.espaciosum.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginConserjeRequestDTO {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
