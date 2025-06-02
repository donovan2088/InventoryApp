package com.inventory.gestioninventarioservice.controller;

import com.inventory.gestioninventarioservice.feingClient.GestionCatalogoClient;
import com.inventory.gestioninventarioservice.model.Inventario;
import com.inventory.gestioninventarioservice.service.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    private final InventarioService inventarioService;
    private final GestionCatalogoClient gestionCatalogoClient;

    public InventarioController(InventarioService inventarioService, GestionCatalogoClient gestionCatalogoClient) {
        this.inventarioService = inventarioService;
        this.gestionCatalogoClient = gestionCatalogoClient;
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<?> getInventario(@PathVariable Long productoId){
            var stock = inventarioService.getStock(productoId);
                if (stock.isEmpty()) return ResponseEntity.notFound().build();
            var producto = gestionCatalogoClient.getProducto(productoId);
        return ResponseEntity.ok(Map.of("producto", producto, "stock", stock.get()));
    }

    @PostMapping("/incrementarStock")
    public Inventario incrementarStock(@RequestParam Long productoId, @RequestParam int cantidad){
            Inventario inventario = inventarioService.getStock(productoId).orElse(new Inventario(productoId, 0));
            inventario.setCantidad(inventario.getCantidad() + cantidad);
        return inventarioService.save(inventario);
    }

    @PostMapping("/decrementarStock")
    public ResponseEntity<?> decrementarStock(@RequestParam Long productId, @RequestParam int cantidad){
        Inventario inventario = inventarioService.getStock(productId).orElse(null);
        if(inventario == null || inventario.getCantidad() < cantidad)
            return ResponseEntity.badRequest().body("Insuficiente stock");
        inventario.setCantidad(inventario.getCantidad() - cantidad);
        return ResponseEntity.ok(inventarioService.save(inventario));
    }
}
