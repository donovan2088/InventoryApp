package com.inventory.gestioninventarioservice.repository;

import com.inventory.gestioninventarioservice.model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventorioRepository extends JpaRepository<Inventario, Long> {
    Optional<Inventario> findById(Long productoId);
}
