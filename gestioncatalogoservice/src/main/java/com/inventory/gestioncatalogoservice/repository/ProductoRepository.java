package com.inventory.gestioncatalogoservice.repository;

import com.inventory.gestioncatalogoservice.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {}
