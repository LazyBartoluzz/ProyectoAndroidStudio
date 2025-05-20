package com.example.demo.controladores;

import com.example.demo.modelos.Orden;
import com.example.demo.servicios.OrdenService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {

    private final OrdenService ordenService;

    public OrdenController(OrdenService ordenService) {
        this.ordenService = ordenService;
    }

    @GetMapping
    public List<Orden> getAll() {
        return ordenService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orden> getById(@PathVariable Long id) {
        return ordenService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Orden create(@RequestBody Orden orden) {
        return ordenService.save(orden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orden> update(@PathVariable Long id, @RequestBody Orden orden) {
        orden.setId(id);
        return ResponseEntity.ok(ordenService.save(orden));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        ordenService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Nativas

    @GetMapping("/mesero/{idMesero}")
    public List<Orden> getOrdenesPorMesero(@PathVariable Long idMesero) {
        return ordenService.findByMeseroId(idMesero);
    }

    @GetMapping("/mesero/{idMesero}/fecha")
    public List<Orden> getOrdenesPorMeseroYFecha(
            @PathVariable Long idMesero,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ordenService.findByMeseroIdAndFecha(idMesero, fecha);
    }
}
