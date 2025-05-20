package com.example.demo.controladores;

import com.example.demo.modelos.PlatoEspecial;
import com.example.demo.servicios.PlatoEspecialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos-especiales")
public class PlatoEspecialController {

    private final PlatoEspecialService platoEspecialService;

    public PlatoEspecialController(PlatoEspecialService platoEspecialService) {
        this.platoEspecialService = platoEspecialService;
    }

    @GetMapping
    public List<PlatoEspecial> getAll() {
        return platoEspecialService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatoEspecial> getById(@PathVariable Long id) {
        return platoEspecialService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PlatoEspecial create(@RequestBody PlatoEspecial platoEspecial) {
        return platoEspecialService.save(platoEspecial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlatoEspecial> update(@PathVariable Long id, @RequestBody PlatoEspecial platoEspecial) {
        platoEspecial.setId(id);
        return ResponseEntity.ok(platoEspecialService.save(platoEspecial));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        platoEspecialService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
