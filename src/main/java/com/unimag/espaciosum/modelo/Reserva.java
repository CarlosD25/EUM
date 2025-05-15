package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "espacioId")
    private Espacio espacio;

    @OneToOne
    @JoinColumn(name = "horarioId")
    private Horario horario;
}
