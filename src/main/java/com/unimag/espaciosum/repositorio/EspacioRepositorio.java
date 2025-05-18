package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspacioRepositorio extends JpaRepository<Espacio, Long> {
}
