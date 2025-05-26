package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Import(TestcontainersConfiguration.class)
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ReservaRepositorioTest {

    @Autowired
    private ReservaRepositorio reservaRepositorio;
    @Autowired
    private EstudianteRepositorio estudianteRepositorio;
    @Autowired
    private EspacioRepositorio espacioRepositorio;
    @Autowired
    private ProfesorRepositorio profesorRepositorio;
    @Autowired
    private HorarioRepositorio horarioRepositorio;

    @BeforeEach
    void setUp() {
        Estudiante estudiante1 = Estudiante.builder()
                .nombre("Daniel Mogolla")
                .email("danimogo@hotmail.com")
                .codigo("2022114022")
                .identificacion("106758888")
                .password("danimogo123")
                .build();

        Estudiante estudiante2 = Estudiante.builder()
                .nombre("Laura Torres")
                .email("lauratorres@gmail.com")
                .codigo("2022114023")
                .identificacion("106758889")
                .password("laura123")
                .build();

        Estudiante estudiante3 = Estudiante.builder()
                .nombre("Andrés Gómez")
                .email("andresgomez@hotmail.com")
                .codigo("2022114024")
                .identificacion("106758890")
                .password("andres123")
                .build();

        estudianteRepositorio.saveAll(List.of(
                estudiante1, estudiante2, estudiante3
        ));

        Espacio espacio1 = Espacio.builder()
                .nombre("Mar Caribe 302")
                .tipo("Salón")
                .capacidad(40)
                .build();

        Espacio espacio2 = Espacio.builder()
                .nombre("Pacífico 101")
                .tipo("Auditorio")
                .capacidad(100)
                .build();

        Espacio espacio3 = Espacio.builder()
                .nombre("Atlántico 205")
                .tipo("Laboratorio")
                .capacidad(25)
                .build();

        espacioRepositorio.saveAll(List.of(
                espacio1, espacio2, espacio3
        ));

        Profesor profesor1 = Profesor.builder()
                .nombre("Carlos Nelson")
                .email("cnelson@gmail.com")
                .identificacion("123456789")
                .password("salchipapa123")
                .build();

        Profesor profesor2 = Profesor.builder()
                .nombre("Martha Ruiz")
                .email("mruiz@gmail.com")
                .identificacion("987654321")
                .password("contraseña456")
                .build();

        Profesor profesor3 = Profesor.builder()
                .nombre("Luis González")
                .email("lgonzalez@gmail.com")
                .identificacion("111222333")
                .password("password123")
                .build();

        profesorRepositorio.saveAll(List.of(
                profesor1, profesor2, profesor3
        ));

        Horario horario1 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 25, 8, 0))
                .horaFin(LocalDateTime.of(2025, 5, 25, 10, 0))
                .espacio(espacio1)
                .build();

        Horario horario2 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 25, 10, 0))
                .horaFin(LocalDateTime.of(2025, 5, 25, 12, 0))
                .espacio(espacio1)
                .build();

        Horario horario3 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 25, 13, 0))
                .horaFin(LocalDateTime.of(2025, 5, 25, 15, 0))
                .espacio(espacio1)
                .build();

        horarioRepositorio.saveAll(List.of(
                horario1, horario2, horario3
        ));

        Reserva reserva1 = Reserva.builder()
                .estudiante(estudiante1)
                .espacio(espacio1)
                .profesor(profesor1)
                .horario(horario1)
                .build();

        Reserva reserva2 = Reserva.builder()
                .estudiante(estudiante2)
                .espacio(espacio2)
                .profesor(profesor2)
                .horario(horario2)
                .build();

        Reserva reserva3 = Reserva.builder()
                .estudiante(estudiante3)
                .espacio(espacio3)
                .profesor(profesor3)
                .horario(horario3)
                .build();

        reservaRepositorio.saveAll(List.of(
                reserva1, reserva2, reserva3
        ));
    }

    @AfterEach
    void tearDown() {

        reservaRepositorio.deleteAll();
        horarioRepositorio.deleteAll();
        estudianteRepositorio.deleteAll();
        espacioRepositorio.deleteAll();
        profesorRepositorio.deleteAll();

    }

    @Test
    void obtenerReservaPorId(){
        Reserva reserva = reservaRepositorio.findById(1L).get();
        Estudiante estudiante = reserva.getEstudiante();
        Profesor profesor = reserva.getProfesor();
        Horario horario = reserva.getHorario();
        Espacio espacio = reserva.getEspacio();
        assertEquals(estudiante, estudianteRepositorio.findById(1L).get());
        assertEquals(profesor, profesorRepositorio.findById(1L).get());
        assertEquals(horario, horarioRepositorio.findById(1L).get());
        assertEquals(espacio, espacioRepositorio.findById(1L).get());
    }

    @Test
    void obtenerTodasLasReservas(){
        List<Reserva> reservas = reservaRepositorio.findAll();
        assertTrue(reservas.size()==3);
    }

    @Test
    void actualizarReserva(){
        Reserva reserva = reservaRepositorio.findById(1L).get();
        reserva.setEspacio(espacioRepositorio.findById(2L).get());
        reserva.setProfesor(profesorRepositorio.findById(2L).get());
        reserva.setEstudiante(estudianteRepositorio.findById(2L).get());
        reservaRepositorio.save(reserva);
        Reserva actualizado = reservaRepositorio.findById(1L).get();
        assertEquals(actualizado.getEstudiante(), estudianteRepositorio.findById(2L).get());
        assertEquals(actualizado.getEspacio(), espacioRepositorio.findById(2L).get());
        assertEquals(actualizado.getProfesor(), profesorRepositorio.findById(2L).get());
    }

    @Test
    void eliminarReserva(){
        reservaRepositorio.deleteById(1L);
        Optional<Reserva> reserva = reservaRepositorio.findById(1L);
        assertFalse(reserva.isPresent());
    }

    @Test
    void reservasEstudianteId() {
        List<Reserva> reservas = reservaRepositorio.reservasEstudianteId(1L);
        assertTrue(reservas.size()==1);
    }

    @Test
    void reservasProfesorId() {
        List<Reserva> reservas = reservaRepositorio.reservasProfesorId(1L);
        assertTrue(reservas.size()==1);
    }
}