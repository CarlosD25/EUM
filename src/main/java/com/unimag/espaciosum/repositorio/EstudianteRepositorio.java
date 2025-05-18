package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {

}
