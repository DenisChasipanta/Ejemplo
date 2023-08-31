package com.istqmet.SprinJBC.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Persona {

    @Id
    private  String cedula;
    private String nombre;
    private String apellido;
    private String Celular;
}
