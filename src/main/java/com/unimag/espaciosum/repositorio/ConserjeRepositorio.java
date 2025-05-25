package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Conserje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ConserjeRepositorio extends JpaRepository<Conserje, Long> {

    @Query("SELECT c FROM Conserje c WHERE c.email = :email AND c.password = :password")
    Optional<Conserje> buscarPorEmailYContrasena(@Param("email") String email, @Param("password") String password);
}
