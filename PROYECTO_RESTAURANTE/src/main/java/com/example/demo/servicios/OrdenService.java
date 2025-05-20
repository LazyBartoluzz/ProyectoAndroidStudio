package com.example.demo.servicios;

import com.example.demo.modelos.Orden;
import com.example.demo.repositorios.OrdenRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenService {

    private final OrdenRepository ordenRepository;

    public OrdenService(OrdenRepository ordenRepository) {
        this.ordenRepository = ordenRepository;
    }

    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

    @Transactional
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Transactional
    public void deleteById(Long id) {
        ordenRepository.deleteById(id);
    }

    public List<Orden> findByMeseroId(Long idMesero) {
        return ordenRepository.findOrdenesByMeseroId(idMesero);
    }

    public List<Orden> findByMeseroIdAndFecha(Long idMesero, LocalDate fecha) {
        return ordenRepository.findOrdenesByMeseroIdAndFecha(idMesero, fecha);
    }
}
