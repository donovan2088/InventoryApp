package com.inventory.gestioninventarioservice.feingClient;

import com.inventory.gestioninventarioservice.dto.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="gestioncatalogoclient", url="http://localhost:8080")
public interface GestionCatalogoClient {
    @GetMapping("/productos/{id}")
    Producto getProducto(@PathVariable("id") Long id);

}
