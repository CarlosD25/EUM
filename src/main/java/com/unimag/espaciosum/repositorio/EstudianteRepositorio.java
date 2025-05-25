package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {

    @Query("SELECT e FROM Estudiante e WHERE e.codigo = :codigo AND e.password = :password")
    Optional<Estudiante> buscarPorCodigoYContrasena(@Param("codigo") String codigo, @Param("password") String password);

}
