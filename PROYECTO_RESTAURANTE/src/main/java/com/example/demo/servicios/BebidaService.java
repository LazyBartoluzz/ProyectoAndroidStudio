package com.example.demo.servicios;

import com.example.demo.modelos.Bebida;
import com.example.demo.repositorios.BebidaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {

    private final BebidaRepository bebidaRepository;

    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public List<Bebida> findAll() {
        return bebidaRepository.findAll();
    }

    public Optional<Bebida> findById(Long id) {
        return bebidaRepository.findById(id);
    }

    @Transactional
    public Bebida save(Bebida bebida) {
        return bebidaRepository.save(bebida);
    }

    @Transactional
    public void deleteById(Long id) {
        bebidaRepository.deleteById(id);
    }

    public Integer getStockMinimo(Long id) {
        return bebidaRepository.findStockMinimoById(id);
    }

    public Integer getStockActual(Long id) {
        return bebidaRepository.findStockActualById(id);
    }

    @Transactional
    public void asignarStockMaximoATodas() {
        bebidaRepository.asignarStockMaximoATodasLasBebidas();
    }

    @Transactional
    public void actualizarStockActual(Long id, Integer nuevoStock) {
        bebidaRepository.actualizarStockActualPorId(id, nuevoStock);
    }
}
