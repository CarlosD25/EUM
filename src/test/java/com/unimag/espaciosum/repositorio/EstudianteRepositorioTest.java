package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Estudiante;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Import(TestcontainersConfiguration.class)
@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EstudianteRepositorioTest {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

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

        Estudiante estudiante4 = Estudiante.builder()
                .nombre("María Ramírez")
                .email("mariaramirez@gmail.com")
                .codigo("2022114025")
                .identificacion("106758891")
                .password("maria123")
                .build();

        Estudiante estudiante5 = Estudiante.builder()
                .nombre("Pedro López")
                .email("pedrolopez@hotmail.com")
                .codigo("2022114026")
                .identificacion("106758892")
                .password("pedro123")
                .build();

        Estudiante estudiante6 = Estudiante.builder()
                .nombre("Lucía Fernández")
                .email("luciafernandez@gmail.com")
                .codigo("2022114027")
                .identificacion("106758893")
                .password("lucia123")
                .build();

        Estudiante estudiante7 = Estudiante.builder()
                .nombre("Carlos Martínez")
                .email("carlosmartinez@hotmail.com")
                .codigo("2022114028")
                .identificacion("106758894")
                .password("carlos123")
                .build();

        Estudiante estudiante8 = Estudiante.builder()
                .nombre("Sofía Herrera")
                .email("sofiaherrera@gmail.com")
                .codigo("2022114029")
                .identificacion("106758895")
                .password("sofia123")
                .build();

        Estudiante estudiante9 = Estudiante.builder()
                .nombre("Julián Ríos")
                .email("julianrios@hotmail.com")
                .codigo("2022114030")
                .identificacion("106758896")
                .password("julian123")
                .build();

        Estudiante estudiante10 = Estudiante.builder()
                .nombre("Ana Castillo")
                .email("anacastillo@gmail.com")
                .codigo("2022114031")
                .identificacion("106758897")
                .password("ana123")
                .build();

        estudianteRepositorio.saveAll(List.of(
                estudiante1, estudiante2, estudiante3, estudiante4, estudiante5,
                estudiante6, estudiante7, estudiante8, estudiante9, estudiante10
        ));
    }

    @AfterEach
    void tearDown() {
        estudianteRepositorio.deleteAll();
    }

    @Test
    void obtenerEstudiantePorId() {
        Estudiante estudiante = estudianteRepositorio.findById(1L).get();
        assertEquals("Daniel Mogolla", estudiante.getNombre());
        assertEquals("danimogo@hotmail.com", estudiante.getEmail());
        assertEquals("2022114022", estudiante.getCodigo());
        assertEquals("106758888", estudiante.getIdentificacion());
        assertEquals("danimogo123", estudiante.getPassword());
    }

    @Test
    void obtenerTodosLosEstudiantes(){
        List<Estudiante> estudiantes = estudianteRepositorio.findAll();
        assertTrue(estudiantes.size()==10);
    }

    @Test
    void actualizarEstudiante() {
        Estudiante estudiante = estudianteRepositorio.findById(1L).get();
        estudiante.setNombre("El niño");
        estudiante.setEmail("elniñoRinconesto@hotmail.com");
        estudiante.setCodigo("44444444");
        estudiante.setIdentificacion("19777874545");
        estudiante.setPassword("elni123");
        estudianteRepositorio.save(estudiante);
        Estudiante actualizado= estudianteRepositorio.findById(1L).get();
        assertEquals(actualizado.getNombre(),"El niño");
        assertEquals(actualizado.getEmail(),"elniñoRinconesto@hotmail.com");
        assertEquals(actualizado.getCodigo(),"44444444");
        assertEquals(actualizado.getIdentificacion(),"19777874545");
        assertEquals(actualizado.getPassword(),"elni123");
    }

    @Test
    void eliminarEstudiante() {
        estudianteRepositorio.deleteById(1L);
        Optional<Estudiante> estudiante = estudianteRepositorio.findById(1L);
        assertFalse(estudiante.isPresent());
    }

    @Test
    void buscarPorCodigoYContrasena() {
        Estudiante estudiante = estudianteRepositorio.findById(1L).get();
        String codigo = estudiante.getCodigo();
        String password = estudiante.getPassword();
        Optional<Estudiante> encontrado = estudianteRepositorio.buscarPorCodigoYContrasena(codigo, password);
        assertTrue(encontrado.isPresent());
    }
}