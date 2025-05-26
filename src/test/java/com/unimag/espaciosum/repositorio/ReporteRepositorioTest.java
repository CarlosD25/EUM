package com.unimag.espaciosum.repositorio;

import com.unimag.espaciosum.modelo.Conserje;
import com.unimag.espaciosum.modelo.Espacio;
import com.unimag.espaciosum.modelo.Reporte;
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
class ReporteRepositorioTest {

    @Autowired
    private ReporteRepositorio reporteRepositorio;
    @Autowired
    private ConserjeRepositorio conserjeRepositorio;
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


        Reporte reporte1 = Reporte.builder()
                .descripcion("5 PC dañados")
                .espacio(espacio1)
                .conserje(conserje1)
                .build();

        Reporte reporte2 = Reporte.builder()
                .descripcion("Luz dañada en el salón")
                .espacio(espacio2)
                .conserje(conserje2)
                .build();

        Reporte reporte3 = Reporte.builder()
                .descripcion("Fuga de agua en el baño")
                .espacio(espacio3)
                .conserje(conserje3)
                .build();

        Reporte reporte4 = Reporte.builder()
                .descripcion("Pizarrón roto")
                .espacio(espacio4)
                .conserje(conserje4)
                .build();

        Reporte reporte5 = Reporte.builder()
                .descripcion("Aire acondicionado no funciona")
                .espacio(espacio5)
                .conserje(conserje5)
                .build();

        conserjeRepositorio.saveAll(List.of(
                conserje1, conserje2, conserje3, conserje4, conserje5
        ));

        espacioRepositorio.saveAll(List.of(
                espacio1, espacio2, espacio3, espacio4, espacio5
        ));

        reporteRepositorio.saveAll(List.of(
                reporte1, reporte2, reporte3, reporte4, reporte5
        ));

    }

    @AfterEach
    void tearDown() {
        reporteRepositorio.deleteAll();
        conserjeRepositorio.deleteAll();
        espacioRepositorio.deleteAll();
    }

    @Test
    void obtenerReportePorId(){
        Reporte reporte = reporteRepositorio.findById(1L).get();
        Espacio espacio = espacioRepositorio.findById(1L).get();
        Conserje conserje = conserjeRepositorio.findById(1L).get();
        assertEquals("5 PC dañados", reporte.getDescripcion());
        assertEquals(espacio, reporte.getEspacio());
        assertEquals(conserje, reporte.getConserje());
    }

    @Test
    void obtenerTodosLosReportes(){
        List<Reporte> reportes = reporteRepositorio.findAll();
        assertTrue(reportes.size()==5);
    }

    @Test
    void actualizarReporte(){
        Reporte reporte = reporteRepositorio.findById(1L).get();
        reporte.setDescripcion("Sala no disponible");
        reporteRepositorio.save(reporte);
        Reporte actualizado=reporteRepositorio.findById(1L).get();
        assertEquals(reporte.getDescripcion(), actualizado.getDescripcion());
    }

    @Test
    void eliminarReporte(){
        reporteRepositorio.deleteById(1L);
        Optional<Reporte> reporte = reporteRepositorio.findById(1L);
        assertFalse(reporte.isPresent());
    }
}