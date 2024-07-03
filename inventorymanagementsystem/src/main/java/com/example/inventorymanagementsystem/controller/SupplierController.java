package com.example.inventorymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventorymanagementsystem.model.Supplier;
import com.example.inventorymanagementsystem.service.SupplierService;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * Endpoint to retrieve all suppliers.
     *
     * @return List of suppliers.
     */
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        return ResponseEntity.ok().body(suppliers);
    }

    /**
     * Endpoint to add a new supplier.
     *
     * @param supplier Supplier object to add.
     * @return Added supplier.
     */
    @PostMapping
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier addedSupplier = supplierService.addSupplier(supplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedSupplier);
    }

    /**
     * Endpoint to update an existing supplier.
     *
     * @param id       ID of the supplier to update.
     * @param supplier Updated supplier object.
     * @return Updated supplier.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier updatedSupplier = supplierService.updateSupplier(id, supplier);
        return ResponseEntity.ok().body(updatedSupplier);
    }

    /**
     * Endpoint to delete a supplier.
     *
     * @param id ID of the supplier to delete.
     * @return ResponseEntity with status indicating success or failure.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}
