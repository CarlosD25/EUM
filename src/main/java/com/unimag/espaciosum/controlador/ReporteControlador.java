package com.unimag.espaciosum.controlador;

import com.unimag.espaciosum.dto.request.ReporteRequestDTO;
import com.unimag.espaciosum.dto.response.ReporteResponseDTO;
import com.unimag.espaciosum.servicio.ReporteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reportes")
@RequiredArgsConstructor
public class ReporteControlador {

    private final ReporteServicio reporteServicio;

    @PostMapping
    public ReporteResponseDTO crearReporte(ReporteRequestDTO reporteRequestDTO) {
        return reporteServicio.create(reporteRequestDTO);
    }

    @GetMapping
    public List<ReporteResponseDTO> todosLosReportes() {
        return reporteServicio.findAll();
    }

    @GetMapping("/{id}")
    public ReporteResponseDTO reporteId( @PathVariable Long id) {
        return reporteServicio.finbyId(id);
    }

    @PutMapping("/{id}")
    public ReporteResponseDTO actualizarReporte( @PathVariable Long id, ReporteRequestDTO reporteRequestDTO) {
        return reporteServicio.update(id,reporteRequestDTO );
    }

    @DeleteMapping("/{id}")
    public void borrarReporte(@PathVariable Long id) {
        reporteServicio.delete(id);
    }
}
