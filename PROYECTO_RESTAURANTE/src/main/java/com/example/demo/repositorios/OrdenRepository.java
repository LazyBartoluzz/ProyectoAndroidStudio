package com.example.demo.repositorios;

import com.example.demo.modelos.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {

    @Query(value = "SELECT * FROM orden WHERE id_mesero = :idMesero", nativeQuery = true)
    List<Orden> findOrdenesByMeseroId(@Param("idMesero") Long idMesero);

    @Query(value = "SELECT * FROM orden WHERE id_mesero = :idMesero AND fecha = :fecha", nativeQuery = true)
    List<Orden> findOrdenesByMeseroIdAndFecha(@Param("idMesero") Long idMesero, @Param("fecha") LocalDate fecha);
}
