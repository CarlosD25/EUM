package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;

    @ManyToOne
    @JoinColumn(name = "espacio_id")
    private Espacio espacio;

}
