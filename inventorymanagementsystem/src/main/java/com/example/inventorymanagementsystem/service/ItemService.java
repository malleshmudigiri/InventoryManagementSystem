package com.example.inventorymanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.inventorymanagementsystem.model.Item;
import com.example.inventorymanagementsystem.repository.ItemJpaRepository;
import com.example.inventorymanagementsystem.repository.ItemRepository;

@Service
public class ItemService implements ItemRepository {

    @Autowired
    private ItemJpaRepository itemJpaRepository;
    
    

    @Override
    public ArrayList<Item> getAllItems() {
        List<Item> itemList = itemJpaRepository.findAll();
        return new ArrayList<>(itemList);
    }

    @Override
    public Item addItem(Item item) {
       
        return itemJpaRepository.save(item);
        
       
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> optionalItem = itemJpaRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with id: " + id);
        }
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Optional<Item> optionalItem = itemJpaRepository.findById(id);

        if (optionalItem.isPresent()) {
            Item existingItem = optionalItem.get();
            
            if (item.getItemName() != null) {
                existingItem.setItemName(item.getItemName());
            }
            if (item.getQuantity() != 0) {
                existingItem.setQuantity(item.getQuantity());
            }
            if (item.getPrice() != 0) {
                existingItem.setPrice(item.getPrice());
            }
            
            

            return itemJpaRepository.save(existingItem);
        
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with id: " + id);
        }
    }

    @Override
    public void deleteItem(Long id) {
        if (itemJpaRepository.existsById(id)) {
            itemJpaRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found with id: " + id);
        }
    }
}
