package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Espacio;
import com.unimag.espaciosum.modelo.Horario;
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
class HorarioRepositorioTest {

    @Autowired
    private HorarioRepositorio horarioRepositorio;
    @Autowired
    private EspacioRepositorio espacioRepositorio;

    @BeforeEach
    void setUp() {

        Espacio espacio1 = Espacio.builder()
                .nombre("Mar Caribe 302")
                .tipo("Salón")
                .capacidad(40)
                .build();

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

        Horario horario4 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 25, 15, 0))
                .horaFin(LocalDateTime.of(2025, 5, 25, 17, 0))
                .espacio(espacio1)
                .build();

        Horario horario5 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 26, 8, 0))
                .horaFin(LocalDateTime.of(2025, 5, 26, 10, 0))
                .espacio(espacio1)
                .build();

        Horario horario6 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 26, 10, 0))
                .horaFin(LocalDateTime.of(2025, 5, 26, 12, 0))
                .espacio(espacio1)
                .build();

        Horario horario7 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 26, 13, 0))
                .horaFin(LocalDateTime.of(2025, 5, 26, 15, 0))
                .espacio(espacio1)
                .build();

        Horario horario8 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 30, 10, 0))
                .horaFin(LocalDateTime.of(2025, 5, 30, 11, 0))
                .espacio(espacio1)
                .build();

        Horario horario9 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 30, 10, 0))
                .horaFin(LocalDateTime.of(2025, 5, 30, 11, 30))
                .espacio(espacio1)
                .build();

        Horario horario10 = Horario.builder()
                .horaInicio(LocalDateTime.of(2025, 5, 30, 10, 0))
                .horaFin(LocalDateTime.of(2025, 5, 30, 12, 0))
                .espacio(espacio1)
                .build();

        espacioRepositorio.save(espacio1);
        horarioRepositorio.saveAll(List.of(
                horario1, horario2, horario3, horario4, horario5,
                horario6, horario7, horario8, horario9, horario10
        ));
    }

    @AfterEach
    void tearDown() {
        horarioRepositorio.deleteAll();
        espacioRepositorio.deleteAll();


    }

    @Test
    void obtenerHorarioPorId(){
        Horario horario = horarioRepositorio.findById(1L).get();
        assertEquals(LocalDateTime.of(2025, 5, 25, 8, 0), horario.getHoraInicio());
        assertEquals(LocalDateTime.of(2025, 5, 25, 10, 0), horario.getHoraFin());
    }

    @Test
    void obtenerTodosLosHorarios(){
        List<Horario> horarios = horarioRepositorio.findAll();
        assertTrue(horarios.size()==10);
    }

    @Test
    void actualizarHorario(){
        Horario horario = horarioRepositorio.findById(1L).get();
        horario.setHoraInicio(LocalDateTime.of(2025, 6, 25, 8, 0));
        horario.setHoraFin(LocalDateTime.of(2025, 7, 25, 10, 0));
        horarioRepositorio.save(horario);
        Horario actualizado = horarioRepositorio.findById(1L).get();
        assertEquals(LocalDateTime.of(2025, 6, 25, 8, 0), actualizado.getHoraInicio());
        assertEquals(LocalDateTime.of(2025, 7, 25, 10, 0), actualizado.getHoraFin());
    }

    @Test
    void eliminarHorario(){
        horarioRepositorio.deleteById(1L);
        Optional<Horario> horario = horarioRepositorio.findById(1L);
        assertFalse(horario.isPresent());
    }

    @Test
    void filtrarHorarioPorEspacio() {
        Espacio espacio = espacioRepositorio.findById(1L).get();
        List<Horario> horarios = horarioRepositorio.filtrarHorarioPorEspacio(espacio.getId());
        assertTrue(horarios.size()==10);
    }

}