package com.example.edgeservice.entity.controller;

import com.example.edgeservice.entity.Item;
import com.example.edgeservice.entity.ItemClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

public class GoodItemApiAdapterRestController {
    private final ItemClient itemClient;

    public GoodItemApiAdapterRestController(ItemClient itemClient) {
        this.itemClient = itemClient;
    }

    @GetMapping("/top-brands")
    public List<Item> goodItems() {
        return itemClient.readItems()
                .stream()
                .filter(this::isGreat)
                .collect(Collectors.toList());
    }
    @GetMapping("item/{id}")
    public Item find(@PathVariable long id){
        return itemClient.findItem(id);
    }
    private boolean isGreat(Item item) {
        return !item.getName().equals("Nike") &&
                !item.getName().equals("Adidas") &&
                !item.getName().equals("Reebok");
    }
}
