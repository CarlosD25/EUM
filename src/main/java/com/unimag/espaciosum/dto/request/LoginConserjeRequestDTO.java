package com.unimag.espaciosum.dto.request;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginConserjeRequestDTO {

    private String email;
    private String password;
}
