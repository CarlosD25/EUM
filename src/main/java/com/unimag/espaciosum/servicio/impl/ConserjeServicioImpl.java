package com.unimag.espaciosum.servicio.impl;

import com.unimag.espaciosum.dto.request.ConserjeRequestDTO;
import com.unimag.espaciosum.dto.request.LoginConserjeRequestDTO;
import com.unimag.espaciosum.dto.response.ConserjeResponseDTO;
import com.unimag.espaciosum.mapper.ConserjeMapper;
import com.unimag.espaciosum.modelo.Conserje;
import com.unimag.espaciosum.repositorio.ConserjeRepositorio;
import com.unimag.espaciosum.servicio.ConserjeServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConserjeServicioImpl implements ConserjeServicio {

    private final ConserjeRepositorio conserjeRepositorio;
    private final ConserjeMapper conserjeMapper;

    @Override
    public ConserjeResponseDTO create(ConserjeRequestDTO conserjeRequestDTO) {
        Conserje conserje =conserjeMapper.toEntity(conserjeRequestDTO);
        return conserjeMapper.toDTO(conserjeRepositorio.save(conserje));
    }

    @Override
    public ConserjeResponseDTO finbyId(Long id) {
        return conserjeRepositorio.findById(id).map(conserjeMapper::toDTO).orElseThrow(()->new RuntimeException("No se encontro un conserje con id "+id));
    }

    @Override
    public List<ConserjeResponseDTO> findAll() {
        return conserjeRepositorio.findAll().stream().map(conserjeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ConserjeResponseDTO update(Long id, ConserjeRequestDTO conserjeRequestDTO) {
        Conserje conserje=conserjeRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro un conserje con id "+id));
        conserje.setNombre(conserjeRequestDTO.getNombre());
        conserje.setEmail(conserjeRequestDTO.getEmail());
        conserje.setPassword(conserjeRequestDTO.getPassword());
        conserje.setIdentificacion(conserjeRequestDTO.getIdentificacion());
        return conserjeMapper.toDTO(conserjeRepositorio.save(conserje));
    }

    @Override
    public void delete(Long id) {

        if(!conserjeRepositorio.existsById(id)) {
            throw new RuntimeException("No se encontro un conserje con id "+id);
        }
        conserjeRepositorio.deleteById(id);

    }

    @Override
    public ConserjeResponseDTO login(LoginConserjeRequestDTO loginConserjeRequestDTO) {
        String email = loginConserjeRequestDTO.getEmail();
        String password = loginConserjeRequestDTO.getPassword();
        Optional<Conserje> conserje = conserjeRepositorio.buscarPorEmailYContrasena(email, password);
        if(conserje.isPresent()) {
            return conserjeMapper.toDTO(conserje.get());
        }
        throw new RuntimeException("No se encontro un conserje con email "+email);
    }
}
