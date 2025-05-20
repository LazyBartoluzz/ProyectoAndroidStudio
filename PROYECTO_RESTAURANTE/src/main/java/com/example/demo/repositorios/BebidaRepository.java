package com.example.demo.repositorios;

import com.example.demo.modelos.Bebida;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<Bebida, Long> {

    @Query(value = "SELECT stock_minimo FROM bebida WHERE id = :id", nativeQuery = true)
    Integer findStockMinimoById(@Param("id") Long id);

    @Query(value = "SELECT stock_actual FROM bebida WHERE id = :id", nativeQuery = true)
    Integer findStockActualById(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bebida SET stock_actual = stock_maximo", nativeQuery = true)
    void asignarStockMaximoATodasLasBebidas();

    @Modifying
    @Transactional
    @Query(value = "UPDATE bebida SET stock_actual = :nuevoStock WHERE id = :id", nativeQuery = true)
    void actualizarStockActualPorId(@Param("id") Long id, @Param("nuevoStock") Integer nuevoStock);
}
