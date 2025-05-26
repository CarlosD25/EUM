package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name= "conserjeId", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Conserje conserje;

    @ManyToOne
    @JoinColumn(name="espacioId",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Espacio espacio;

}
