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
