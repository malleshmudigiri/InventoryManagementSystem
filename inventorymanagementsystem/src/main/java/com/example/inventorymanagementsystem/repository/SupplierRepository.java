package com.example.inventorymanagementsystem.repository;





import java.util.ArrayList;

import com.example.inventorymanagementsystem.model.Supplier;



public interface SupplierRepository {
    ArrayList<Supplier> getAllSuppliers();
    Supplier addSupplier(Supplier supplier);
    Supplier updateSupplier(Long id, Supplier supplier);
    void deleteSupplier(Long id);


}
