package com.example.demo.modelos;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precio;
    private Integer stockMinimo;
    private Integer stockActual;
    private Integer stockMaximo;
    private String descripcion;
    private String urlImagen;

    @OneToMany
    @JoinColumn(name = "id_bebida")
    private List<Orden> ordenesBebidas;

    public String getUrlImagen() {
        return urlImagen;
    }

    public List<Orden> getOrdenesBebidas() {
        return ordenesBebidas;
    }

    public void setOrdenesBebidas(List<Orden> ordenesBebidas) {
        this.ordenesBebidas = ordenesBebidas;
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

    public Integer getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(Integer stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
