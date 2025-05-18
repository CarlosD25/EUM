package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {
}
