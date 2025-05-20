package com.example.demo.servicios;

import com.example.demo.modelos.Plato;
import com.example.demo.modelos.Plato;
import com.example.demo.repositorios.PlatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlatoService {

    private final PlatoRepository platoRepository;

    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public List<Plato> findAll() {
        return platoRepository.findAll();
    }

    public Optional<Plato> findById(Long id) {
        return platoRepository.findById(id);
    }

    @Transactional
    public Plato save(Plato plato) {
        return platoRepository.save(plato);
    }

    @Transactional
    public void deleteById(Long id) {
        platoRepository.deleteById(id);
    }
}
