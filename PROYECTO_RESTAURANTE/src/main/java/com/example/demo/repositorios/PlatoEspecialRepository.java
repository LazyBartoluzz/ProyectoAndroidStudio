package com.example.demo.repositorios;

import com.example.demo.modelos.PlatoEspecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoEspecialRepository extends JpaRepository<PlatoEspecial, Long> {
}
