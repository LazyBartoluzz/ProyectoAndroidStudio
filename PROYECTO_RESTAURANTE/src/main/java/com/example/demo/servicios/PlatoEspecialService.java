package com.example.demo.servicios;

import com.example.demo.modelos.PlatoEspecial;
import com.example.demo.repositorios.PlatoEspecialRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoEspecialService {

    private final PlatoEspecialRepository platoEspecialRepository;

    public PlatoEspecialService(PlatoEspecialRepository platoEspecialRepository) {
        this.platoEspecialRepository = platoEspecialRepository;
    }

    public List<PlatoEspecial> findAll() {
        return platoEspecialRepository.findAll();
    }

    public Optional<PlatoEspecial> findById(Long id) {
        return platoEspecialRepository.findById(id);
    }

    @Transactional
    public PlatoEspecial save(PlatoEspecial platoEspecial) {
        return platoEspecialRepository.save(platoEspecial);
    }

    @Transactional
    public void deleteById(Long id) {
        platoEspecialRepository.deleteById(id);
    }
}
