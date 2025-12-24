package com.example.realestate.controller;

import com.example.realestate.entity.Buyer;
import com.example.realestate.service.BuyerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @PostMapping("/create")
    public Buyer create(@Valid @RequestBody Buyer buyer) {
        return buyerService.save(buyer);
    }

    @GetMapping("/all")
    public List<Buyer> getAll() {
        return buyerService.getAll();
    }

    @GetMapping("/{id}")
    public Buyer getById(@PathVariable Long id) {
        return buyerService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Buyer update(@PathVariable Long id, @Valid @RequestBody Buyer buyer) {
        buyer.setId(id);
        return buyerService.save(buyer);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        buyerService.delete(id);
    }
}
