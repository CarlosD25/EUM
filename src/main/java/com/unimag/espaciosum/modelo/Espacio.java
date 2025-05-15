package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Integer capacidad;

    @OneToMany
    @JoinColumn(name = "espacioId")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "espacio")
    private List<Reporte> reportes;

}
