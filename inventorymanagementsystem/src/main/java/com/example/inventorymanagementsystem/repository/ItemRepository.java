package com.example.inventorymanagementsystem.repository;

import java.util.List;

import com.example.inventorymanagementsystem.model.Item;

public interface ItemRepository {
    List<Item> getAllItems();
    Item addItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    Item getItemById(Long id);
    

}
