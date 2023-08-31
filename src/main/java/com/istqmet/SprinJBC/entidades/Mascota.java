package com.istqmet.SprinJBC.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String especie;
    private String raza;
    private int edad;
    private LocalDate registro;
}
