package com.istqmet.SprinJBC.repositorio;

import com.istqmet.SprinJBC.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, String> {
}
