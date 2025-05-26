package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Conserje;
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
class ConserjeRepositorioTest {

    @Autowired
    private ConserjeRepositorio conserjeRepositorio;

    @BeforeEach
    void setUp() {

        Conserje conserje1 = Conserje.builder()
                .nombre("Dani Mogo")
                .email("danimogo@gmail.com")
                .password("12345")
                .identificacion("1067592779")
                .build();

        Conserje conserje2 = Conserje.builder()
                .nombre("Luis Torres")
                .email("luistorres@gmail.com")
                .password("conserje01")
                .identificacion("1067592880")
                .build();

        Conserje conserje3 = Conserje.builder()
                .nombre("María Quintero")
                .email("mariaq@gmail.com")
                .password("mariaqpass")
                .identificacion("1067592991")
                .build();

        Conserje conserje4 = Conserje.builder()
                .nombre("José Rodríguez")
                .email("joserod@gmail.com")
                .password("jose123")
                .identificacion("1067592112")
                .build();

        Conserje conserje5 = Conserje.builder()
                .nombre("Ana Gómez")
                .email("anagomez@gmail.com")
                .password("ana456")
                .identificacion("1067592333")
                .build();

        Conserje conserje6 = Conserje.builder()
                .nombre("Carlos Méndez")
                .email("carlosmendez@gmail.com")
                .password("carlospass")
                .identificacion("1067592444")
                .build();

        Conserje conserje7 = Conserje.builder()
                .nombre("Lucía Fernández")
                .email("luciaf@gmail.com")
                .password("luciaf12")
                .identificacion("1067592555")
                .build();

        Conserje conserje8 = Conserje.builder()
                .nombre("Pedro Salinas")
                .email("pedrosalinas@gmail.com")
                .password("pedroconserje")
                .identificacion("1067592666")
                .build();

        Conserje conserje9 = Conserje.builder()
                .nombre("Laura Martínez")
                .email("lauram@gmail.com")
                .password("laura999")
                .identificacion("1067592777")
                .build();

        Conserje conserje10 = Conserje.builder()
                .nombre("Miguel Ángel")
                .email("miguelangel@gmail.com")
                .password("miguel123")
                .identificacion("1067592888")
                .build();

        conserjeRepositorio.saveAll(List.of(
                conserje1, conserje2, conserje3, conserje4, conserje5,
                conserje6, conserje7, conserje8, conserje9, conserje10
        ));
    }

    @AfterEach
    void tearDown() {
        conserjeRepositorio.deleteAll();
    }

    @Test
    void obtenerConserjePorId(){
        Optional<Conserje> conserje = conserjeRepositorio.findById(1L);
        assertTrue(conserje.isPresent());
        assertEquals("Dani Mogo", conserje.get().getNombre());
        assertEquals("danimogo@gmail.com", conserje.get().getEmail());
        assertEquals("12345", conserje.get().getPassword());
        assertEquals("1067592779", conserje.get().getIdentificacion());
    }

    @Test
    void obtenerTodosLosConserjes(){
        List<Conserje> conserjes = conserjeRepositorio.findAll();
        assertTrue(conserjes.size()==10);
    }

    @Test
    void actualizarConserje(){
        Conserje conserje = conserjeRepositorio.findById(1L).get();
        conserje.setNombre("Alberto");
        conserje.setEmail("alberto@gmail.com");
        conserje.setPassword("alberto123");
        conserje.setIdentificacion("12345");
        conserjeRepositorio.save(conserje);
        Conserje actualizado = conserjeRepositorio.findById(1L).get();
        assertEquals("Alberto", actualizado.getNombre());
        assertEquals("alberto@gmail.com", actualizado.getEmail());
        assertEquals("12345", actualizado.getIdentificacion());
        assertEquals("alberto123", actualizado.getPassword());
    }

    @Test
    void eliminarConserje(){
        conserjeRepositorio.deleteById(1L);
        Optional<Conserje> conserje = conserjeRepositorio.findById(1L);
        assertFalse(conserje.isPresent());
    }

    @Test
    void buscarPorEmailYContrasena() {
        Conserje conserje = conserjeRepositorio.findById(1L).get();
        String email = conserje.getEmail();
        String password = conserje.getPassword();
        conserjeRepositorio.buscarPorEmailYContrasena(email, password);
        assertEquals("Dani Mogo", conserje.getNombre());
        assertEquals("danimogo@gmail.com", conserje.getEmail());
        assertEquals("12345", conserje.getPassword());
        assertEquals("1067592779", conserje.getIdentificacion());
    }
}