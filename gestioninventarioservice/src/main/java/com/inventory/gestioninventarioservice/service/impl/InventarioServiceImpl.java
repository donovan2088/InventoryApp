package com.inventory.gestioninventarioservice.service.impl;

import com.inventory.gestioninventarioservice.model.Inventario;
import com.inventory.gestioninventarioservice.repository.InventorioRepository;
import com.inventory.gestioninventarioservice.service.InventarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    private final InventorioRepository inventorioRepository;
    public InventarioServiceImpl(InventorioRepository inventorioRepository) {
        this.inventorioRepository = inventorioRepository;
    }

    public Optional<Inventario> getStock(Long id) {
        return inventorioRepository.findById(id);
    }

    public Inventario save(Inventario inventario){
        inventorioRepository.save(inventario);
        return inventario;
    }
}
