package com.example.demo.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double precio;
    private String descripcion;
    private String urlImagen;

    @OneToMany
    @JoinColumn(name = "id_platos")
    private List<Orden> ordenesPlatos;

    public List<Orden> getOrdenesPlatos() {
        return ordenesPlatos;
    }

    public void setOrdenesPlatos(List<Orden> ordenesPlatos) {
        this.ordenesPlatos = ordenesPlatos;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}