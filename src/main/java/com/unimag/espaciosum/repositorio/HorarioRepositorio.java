package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HorarioRepositorio extends JpaRepository<Horario, Long> {

    @Query("SELECT h FROM Horario h WHERE h.espacio.id = :espacioId")
    List<Horario> filtrarHorarioPorEspacio(@Param("espacioId") Long espacioId);

    @Query("SELECT h FROM Horario h WHERE h.espacio.id = :idEspacio AND h.id NOT IN (SELECT r.horario.id FROM Reserva r)")
    List<Horario> filtrarHorariosSinReservaPorEspacio(@Param("idEspacio") Long idEspacio);

}
