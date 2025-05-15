package com.unimag.espaciosum.modelo;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {

    protected String nombre;
    protected String email;
    protected String password;
    protected String identificacion;

}
