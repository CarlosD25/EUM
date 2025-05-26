package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "profesorId",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "espacioId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Espacio espacio;

    @OneToOne
    @JoinColumn(name = "horarioId")
    private Horario horario;
}
