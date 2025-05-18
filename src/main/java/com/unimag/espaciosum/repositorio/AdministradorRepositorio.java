package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepositorio extends JpaRepository<Administrador, Long> {
}
