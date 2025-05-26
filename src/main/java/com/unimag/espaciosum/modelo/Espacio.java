package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Espacio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private Integer capacidad;
    private String tipo;

    @OneToMany(mappedBy = "espacio")
     private List<Horario> horarios;

    @OneToMany(mappedBy = "espacio",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reporte> reportes;

    @OneToMany(mappedBy = "espacio",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas;

}
