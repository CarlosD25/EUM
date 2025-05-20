package com.unimag.espaciosum.modelo;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Usuario {

    protected String nombre;
    protected String email;
    protected String password;
    protected String identificacion;

}
