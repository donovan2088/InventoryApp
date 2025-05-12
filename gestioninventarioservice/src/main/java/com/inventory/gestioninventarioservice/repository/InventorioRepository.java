package com.inventory.gestioninventarioservice.repository;

import com.inventory.gestioninventarioservice.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventorioRepository extends JpaRepository<Inventario, Long> {
}
