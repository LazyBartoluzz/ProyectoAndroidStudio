package com.example.demo.servicios;

import com.example.demo.modelos.Mesero;
import com.example.demo.repositorios.MeseroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MeseroService {

    private final MeseroRepository meseroRepository;

    public MeseroService(MeseroRepository meseroRepository) {
        this.meseroRepository = meseroRepository;
    }

    public List<Mesero> findAll() {
        return meseroRepository.findAll();
    }

    public Optional<Mesero> findById(Long id) {
        return meseroRepository.findById(id);
    }

    @Transactional
    public Mesero save(Mesero mesero) {
        return meseroRepository.save(mesero);
    }

    @Transactional
    public void deleteById(Long id) {
        meseroRepository.deleteById(id);
    }
}
