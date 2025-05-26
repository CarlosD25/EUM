package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Espacio;
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
class EspacioRepositorioTest {

    @Autowired
    private EspacioRepositorio espacioRepositorio;

    @BeforeEach
    void setUp() {

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

        Espacio espacio4 = Espacio.builder()
                .nombre("Mediterráneo 310")
                .tipo("Salón")
                .capacidad(35)
                .build();

        Espacio espacio5 = Espacio.builder()
                .nombre("Andes 410")
                .tipo("Salón")
                .capacidad(45)
                .build();

        Espacio espacio6 = Espacio.builder()
                .nombre("Amazonas B01")
                .tipo("Auditorio")
                .capacidad(120)
                .build();

        Espacio espacio7 = Espacio.builder()
                .nombre("Orinoco 215")
                .tipo("Laboratorio")
                .capacidad(20)
                .build();

        Espacio espacio8 = Espacio.builder()
                .nombre("Guajira 305")
                .tipo("Salón")
                .capacidad(30)
                .build();

        Espacio espacio9 = Espacio.builder()
                .nombre("Nevado 403")
                .tipo("Salón")
                .capacidad(50)
                .build();

        Espacio espacio10 = Espacio.builder()
                .nombre("Sierra Nevada 201")
                .tipo("Auditorio")
                .capacidad(80)
                .build();

        espacioRepositorio.saveAll(List.of(
                espacio1, espacio2, espacio3, espacio4, espacio5,
                espacio6, espacio7, espacio8, espacio9, espacio10
        ));

    }

    @AfterEach
    void tearDown() {
        espacioRepositorio.deleteAll();
    }

    @Test
    void obtenerEspacioPorId(){
        Espacio espacio = espacioRepositorio.findById(1L).get();
        assertEquals("Mar Caribe 302", espacio.getNombre());
        assertEquals(40, espacio.getCapacidad());
        assertEquals("Salón", espacio.getTipo());
    }

    @Test
    void obtenerTodosLosEspacios(){
        List<Espacio> espacios = espacioRepositorio.findAll();
        assertTrue(espacios.size() ==10);
    }

    @Test
    void actualizarEspacio(){
        Espacio espacio = espacioRepositorio.findById(1L).get();
        espacio.setNombre("Sierra nevada norte 202");
        espacio.setCapacidad(50);
        espacio.setTipo("Salón");
        espacioRepositorio.save(espacio);
        Espacio actualizado = espacioRepositorio.findById(1L).get();
        assertEquals(1L, actualizado.getId());
        assertEquals("Sierra nevada norte 202", actualizado.getNombre());
        assertEquals(50, actualizado.getCapacidad());
        assertEquals("Salón",actualizado.getTipo());
    }

    @Test
    void eliminarEspacio(){
        espacioRepositorio.deleteById(1L);
        Optional<Espacio> espacio = espacioRepositorio.findById(1L);
        assertFalse(espacio.isPresent());
    }


    @Test
    void findByTipo() {
        List<Espacio> espacios = espacioRepositorio.findByTipo("Salón");
        assertTrue(espacios.size() ==5);
    }

    @Test
    void findByNombreIgnoreCase() {
        Optional<Espacio> espacio = espacioRepositorio.findByNombreIgnoreCase("nevado 403");
        assertTrue(espacio.isPresent());
    }
}