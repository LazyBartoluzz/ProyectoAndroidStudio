package com.example.demo.controladores;

import com.example.demo.modelos.Plato;
import com.example.demo.servicios.PlatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    private final PlatoService platoService;

    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    @GetMapping
    public List<Plato> getAll() {
        return platoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plato> getById(@PathVariable Long id) {
        return platoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Plato create(@RequestBody Plato plato) {
        return platoService.save(plato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plato> update(@PathVariable Long id, @RequestBody Plato plato) {
        plato.setId(id);
        return ResponseEntity.ok(platoService.save(plato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        platoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
