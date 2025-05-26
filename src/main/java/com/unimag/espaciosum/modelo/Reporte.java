package com.unimag.espaciosum.modelo;

import jakarta.persistence.*;
import lombok.*;

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
    private Conserje conserje;

    @ManyToOne
    @JoinColumn(name="espacioId",referencedColumnName = "id")
    private Espacio espacio;

}
