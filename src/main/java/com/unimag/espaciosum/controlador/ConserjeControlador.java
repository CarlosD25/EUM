package com.unimag.espaciosum.controlador;

import com.unimag.espaciosum.dto.request.ConserjeRequestDTO;
import com.unimag.espaciosum.dto.request.LoginConserjeRequestDTO;
import com.unimag.espaciosum.dto.response.ConserjeResponseDTO;
import com.unimag.espaciosum.servicio.ConserjeServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conserjes")
@RequiredArgsConstructor
public class ConserjeControlador {

    private final ConserjeServicio conserjeServicio;

    @PostMapping("/login")
    public ConserjeResponseDTO loginConserje(@RequestBody LoginConserjeRequestDTO loginConserjeRequestDTO) {
        return conserjeServicio.login(loginConserjeRequestDTO);
    }

    @PostMapping
    public ConserjeResponseDTO crearConserje(@RequestBody ConserjeRequestDTO conserjeRequestDTO) {
        return conserjeServicio.create(conserjeRequestDTO);
    }

    @GetMapping
    public List<ConserjeResponseDTO> todosLosConserjes() {
        return conserjeServicio.findAll();
    }

    @GetMapping("/{id}")
    public ConserjeResponseDTO conserjeId(@PathVariable Long id) {
        return conserjeServicio.finbyId(id);
    }

    @PutMapping("/{id}")
    public ConserjeResponseDTO actualizarConserje(@PathVariable Long id, @RequestBody ConserjeRequestDTO conserjeRequestDTO) {
        return conserjeServicio.update(id, conserjeRequestDTO);
    }

    @DeleteMapping("/{id}")
    public void borrarConserje(@PathVariable Long id) {
        conserjeServicio.delete(id);
    }


}
