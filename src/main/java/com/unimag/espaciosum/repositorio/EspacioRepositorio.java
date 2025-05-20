package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Espacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EspacioRepositorio extends JpaRepository<Espacio, Long> {

    @Query("SELECT e FROM Espacio e WHERE e.tipo = :tipo")
    List<Espacio> findByTipo(@Param("tipo") String tipo);

    @Query("SELECT e FROM Espacio e WHERE LOWER(e.nombre) = LOWER(:nombre)")
    Optional<Espacio> findByNombreIgnoreCase(@Param("nombre") String nombre);

}
