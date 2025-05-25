package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfesorRepositorio extends JpaRepository<Profesor, Long> {

    @Query("SELECT p FROM Profesor p WHERE p.email = :email AND p.password = :password")
    Optional<Profesor> buscarPorEmailYPassword(@Param("email") String email, @Param("password") String password);
}
