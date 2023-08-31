package com.istqmet.SprinJBC.repositorio;

import com.istqmet.SprinJBC.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota,Integer> {
}
