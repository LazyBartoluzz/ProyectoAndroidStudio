package com.example.demo.controladores;

import com.example.demo.modelos.Bebida;
import com.example.demo.servicios.BebidaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    private final BebidaService bebidaService;

    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @GetMapping
    public List<Bebida> getAll() {
        return bebidaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> getById(@PathVariable Long id) {
        return bebidaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Bebida create(@RequestBody Bebida bebida) {
        return bebidaService.save(bebida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bebida> update(@PathVariable Long id, @RequestBody Bebida bebida) {
        bebida.setId(id);
        return ResponseEntity.ok(bebidaService.save(bebida));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bebidaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Nativas

    @GetMapping("/{id}/stock-minimo")
    public Integer getStockMinimo(@PathVariable Long id) {
        return bebidaService.getStockMinimo(id);
    }

    @GetMapping("/{id}/stock-actual")
    public Integer getStockActual(@PathVariable Long id) {
        return bebidaService.getStockActual(id);
    }

    @PutMapping("/asignar-stock-maximo")
    public ResponseEntity<Void> asignarStockMaximoATodas() {
        bebidaService.asignarStockMaximoATodas();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/stock-actual")
    public ResponseEntity<Void> actualizarStockActual(
            @PathVariable Long id,
            @RequestParam Integer nuevoStock) {
        bebidaService.actualizarStockActual(id, nuevoStock);
        return ResponseEntity.noContent().build();
    }
}
