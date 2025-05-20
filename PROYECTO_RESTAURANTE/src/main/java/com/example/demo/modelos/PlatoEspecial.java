package com.example.demo.modelos;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlatoEspecial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precio;
    private Boolean esExotico;
    private String descripcion;
    private String urlImagen;

    @OneToMany
    @JoinColumn(name = "id_plato_especial")
    private List<Orden> ordenesPlatosEspeciales;

    public List<Orden> getOrdenesPlatosEspeciales() {
        return ordenesPlatosEspeciales;
    }

    public void setOrdenesPlatosEspeciales(List<Orden> ordenesPlatosEspeciales) {
        this.ordenesPlatosEspeciales = ordenesPlatosEspeciales;
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

    public Boolean getEsExotico() {
        return esExotico;
    }

    public void setEsExotico(Boolean esExotico) {
        this.esExotico = esExotico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
