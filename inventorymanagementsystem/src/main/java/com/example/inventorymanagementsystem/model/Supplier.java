package com.example.inventorymanagementsystem.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplierId")
    private Long supplierId;

    @Column(name = "supplierName")
    private String name;

    @Column(name = "contactInfo")
    private String contactInfo;

    @OneToMany(mappedBy = "supplier")
    private Set<RestockOrder> restockOrders;

    // Constructors, Getters, and Setters

    public Supplier() {
        // Default constructor required by JPA
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Set<RestockOrder> getRestockOrders() {
        return restockOrders;
    }

    public void setRestockOrders(Set<RestockOrder> restockOrders) {
        this.restockOrders = restockOrders;
    }
}
