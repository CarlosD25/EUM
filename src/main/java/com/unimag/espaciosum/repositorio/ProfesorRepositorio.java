package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long> {
}
