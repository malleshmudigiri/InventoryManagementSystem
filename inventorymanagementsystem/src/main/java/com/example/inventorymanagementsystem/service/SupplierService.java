package com.example.inventorymanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.inventorymanagementsystem.model.Supplier;
import com.example.inventorymanagementsystem.repository.SupplierJpaRepository;
import com.example.inventorymanagementsystem.repository.SupplierRepository;

@Service
public class SupplierService implements SupplierRepository {

    @Autowired
    private SupplierJpaRepository supplierJpaRepository;
    
    @Override
    public ArrayList<Supplier> getAllSuppliers() {
        List<Supplier> supplierList = supplierJpaRepository.findAll();
        return new ArrayList<>(supplierList);
    }
    
    @Override
    public Supplier addSupplier(Supplier supplier) {
        return supplierJpaRepository.save(supplier);
    }
    
    @Override
    @Transactional
    public Supplier updateSupplier(Long id, Supplier supplier) {
        Optional<Supplier> optionalSupplier = supplierJpaRepository.findById(id);
        
        if (optionalSupplier.isPresent()) {
            Supplier existingSupplier = optionalSupplier.get();
            existingSupplier.setName(supplier.getName());
            existingSupplier.setContactInfo(supplier.getContactInfo());
            return supplierJpaRepository.save(existingSupplier);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found with id: " + id);
        }
    }
    
    @Override
    public void deleteSupplier(Long id) {
        supplierJpaRepository.deleteById(id);
    }
}
