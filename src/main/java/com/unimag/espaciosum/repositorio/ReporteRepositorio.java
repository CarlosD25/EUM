package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepositorio extends JpaRepository<Reporte, Long> {

    List<Reporte> findByEspacioId(Long espacioId);

}
