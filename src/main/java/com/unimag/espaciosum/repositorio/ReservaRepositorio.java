package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {

    @Query("SELECT r FROM Reserva r WHERE r.estudiante.id = :estudianteId")
    List<Reserva> reservasEstudianteId(@Param("estudianteId") Long estudianteId);

    @Query("SELECT r FROM Reserva r WHERE r.profesor.id = :profesorId")
    List<Reserva> reservasProfesorId(@Param("profesorId") Long profesorId);

    boolean existsByHorarioId(Long horarioId);


}
