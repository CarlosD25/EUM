package com.unimag.espaciosum.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Usuario {

    @NotBlank
    protected String nombre;

    @NotBlank
    @Column(unique = true)
    protected String email;

    @NotBlank
    protected String password;

    @NotBlank
    @Column(unique = true)
    protected String identificacion;

}
