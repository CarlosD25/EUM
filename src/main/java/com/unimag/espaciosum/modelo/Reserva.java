package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "estudianteId",referencedColumnName = "id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "profesorId",referencedColumnName = "id")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "espacioId")
    private Espacio espacio;

    @ManyToOne
    @JoinColumn(name = "horarioId", nullable = false)
    private Horario horario;
}
