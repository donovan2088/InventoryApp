package com.inventory.gestioninventarioservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inventario {
    @Id
    private Long productoId;
    private int cantidad;

    public Inventario(Long productoId, int i) {
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
