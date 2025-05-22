package com.unimag.espaciosum.controlador;


import com.unimag.espaciosum.dto.request.EspacioRequestDTO;
import com.unimag.espaciosum.dto.response.EspacioResponseDTO;
import com.unimag.espaciosum.servicio.EspacioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/espacios")
@RequiredArgsConstructor
public class EspacioControlador {

    private final EspacioServicio espacioServicio;

    @PostMapping
    public EspacioResponseDTO crearEspacio(@RequestBody EspacioRequestDTO espacioRequestDTO) {
        return espacioServicio.create(espacioRequestDTO);
    }

    @GetMapping
    public List<EspacioResponseDTO> todosLosEspacios() {
        return espacioServicio.findAll();
    }

    @GetMapping("/{id}")
    public EspacioResponseDTO espacioId( @PathVariable Long id) {
        return espacioServicio.finbyId(id);
    }

    @PutMapping("/{id}")
    public EspacioResponseDTO actualizarEspacio(@PathVariable Long id,@RequestBody EspacioRequestDTO espacioRequestDTO) {
        return espacioServicio.update(id, espacioRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void borrarEspacio(@PathVariable Long id) {
        espacioServicio.delete(id);
    }


}
