package com.example.demo.controladores;

import com.example.demo.modelos.Mesero;
import com.example.demo.servicios.MeseroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meseros")
public class MeseroController {

    private final MeseroService meseroService;

    public MeseroController(MeseroService meseroService) {
        this.meseroService = meseroService;
    }

    @GetMapping
    public List<Mesero> getAll() {
        return meseroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesero> getById(@PathVariable Long id) {
        return meseroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mesero create(@RequestBody Mesero mesero) {
        return meseroService.save(mesero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesero> update(@PathVariable Long id, @RequestBody Mesero mesero) {
        mesero.setId(id);
        return ResponseEntity.ok(meseroService.save(mesero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        meseroService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
