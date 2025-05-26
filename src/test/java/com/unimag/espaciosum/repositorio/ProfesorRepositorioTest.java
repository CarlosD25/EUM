package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Profesor;
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
class ProfesorRepositorioTest {

    @Autowired
    private ProfesorRepositorio profesorRepositorio;

    @BeforeEach
    void setUp() {
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

        Profesor profesor4 = Profesor.builder()
                .nombre("Ana María López")
                .email("amlopez@gmail.com")
                .identificacion("444555666")
                .password("clave789")
                .build();

        Profesor profesor5 = Profesor.builder()
                .nombre("José Martínez")
                .email("jmartinez@gmail.com")
                .identificacion("777888999")
                .password("seguro123")
                .build();

        Profesor profesor6 = Profesor.builder()
                .nombre("Patricia Torres")
                .email("ptorres@gmail.com")
                .identificacion("121314151")
                .password("abc12345")
                .build();

        Profesor profesor7 = Profesor.builder()
                .nombre("Ricardo Mejía")
                .email("rmejia@gmail.com")
                .identificacion("161718192")
                .password("ricardo789")
                .build();

        Profesor profesor8 = Profesor.builder()
                .nombre("Sandra Pérez")
                .email("sperez@gmail.com")
                .identificacion("202122232")
                .password("sandrapass")
                .build();

        Profesor profesor9 = Profesor.builder()
                .nombre("Héctor Castro")
                .email("hcastro@gmail.com")
                .identificacion("242526272")
                .password("castro321")
                .build();

        Profesor profesor10 = Profesor.builder()
                .nombre("Juliana Ramírez")
                .email("jramirez@gmail.com")
                .identificacion("282930313")
                .password("juliana321")
                .build();

        profesorRepositorio.saveAll(List.of(
                profesor1, profesor2, profesor3, profesor4, profesor5,
                profesor6, profesor7, profesor8, profesor9, profesor10
        ));

    }

    @AfterEach
    void tearDown() {
        profesorRepositorio.deleteAll();
    }

    @Test
    void obtenerProfesorPorId(){
        Profesor profesor = profesorRepositorio.findById(1L).get();
        assertEquals("Carlos Nelson", profesor.getNombre());
        assertEquals("cnelson@gmail.com", profesor.getEmail());
        assertEquals("123456789", profesor.getIdentificacion());
        assertEquals("salchipapa123", profesor.getPassword());
    }

    @Test
    void obtenerTodosLosProfesores(){
        List<Profesor> profesores = profesorRepositorio.findAll();
        assertTrue(profesores.size()==10);
    }

    @Test
    void actualizarProfesor(){
        Profesor profesor = profesorRepositorio.findById(1L).get();
        profesor.setNombre("Nalling Bukele");
        profesor.setEmail("nallingbukele@gmail.com");
        profesor.setIdentificacion("44477");
        profesor.setPassword("12345");
        profesorRepositorio.save(profesor);
        Profesor actualizado = profesorRepositorio.findById(1L).get();
        assertEquals("Nalling Bukele", actualizado.getNombre());
        assertEquals("nallingbukele@gmail.com", actualizado.getEmail());
        assertEquals("44477", actualizado.getIdentificacion());
        assertEquals("12345", actualizado.getPassword());
    }

    @Test
    void eliminarProfesor(){
        profesorRepositorio.deleteById(1L);
        Optional<Profesor> profesor = profesorRepositorio.findById(1L);
        assertFalse(profesor.isPresent());
    }

    @Test
    void buscarPorEmailYPassword() {
        Profesor profesor = profesorRepositorio.findById(1L).get();
        String password = profesor.getPassword();
        String email = profesor.getEmail();
        Optional<Profesor> existe=profesorRepositorio.buscarPorEmailYPassword(email, password);
        assertTrue(existe.isPresent());
    }
}