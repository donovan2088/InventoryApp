package com.inventory.gestioncatalogoservice.controller;

import com.inventory.gestioncatalogoservice.model.Producto;
import com.inventory.gestioncatalogoservice.repository.ProductoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping("/getProductos")
    public ResponseEntity<List<Producto>> getAll() {
        return ResponseEntity.ok(productoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProducto(@PathVariable Long id) {
        return productoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto p) {
        return productoRepository.save(p);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable Long id, @RequestBody Producto p) {
        return productoRepository.findById(id).map(existing -> {
            existing.setNombre(p.getNombre());
            existing.setDescripcion(p.getDescripcion());
            existing.setPrecio(p.getPrecio());
            return ResponseEntity.ok(productoRepository.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteProcuto(@PathVariable Long id) {
        productoRepository.deleteById(id);
    }
}
