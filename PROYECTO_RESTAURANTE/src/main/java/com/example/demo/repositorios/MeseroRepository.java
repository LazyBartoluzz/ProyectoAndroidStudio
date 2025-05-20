package com.example.demo.repositorios;

import com.example.demo.modelos.Mesero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeseroRepository extends JpaRepository<Mesero, Long> {
}
