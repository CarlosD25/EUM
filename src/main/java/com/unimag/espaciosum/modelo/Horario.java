package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Espacio espacio;

}
