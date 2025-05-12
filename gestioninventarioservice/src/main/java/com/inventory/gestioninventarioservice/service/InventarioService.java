package com.inventory.gestioninventarioservice.service;

import com.inventory.gestioninventarioservice.model.Inventario;

import java.util.Optional;

public interface InventarioService {

    public Optional<Inventario> getStock(Long id);

}
