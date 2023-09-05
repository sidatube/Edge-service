package com.example.edgeservice.entity;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("ITEM-CATALOG-SERVICE")
public interface ItemClient {
    @GetMapping("/getAll")
    List<Item> readItems();
    @GetMapping("/find/{id}")
    Item findItem(@PathVariable long id);
}
