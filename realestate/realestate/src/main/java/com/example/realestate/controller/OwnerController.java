package com.example.realestate.controller;

import com.example.realestate.entity.Owner;
import com.example.realestate.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/create")
    public Owner create(@Valid @RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @GetMapping("/all")
    public List<Owner> getAll() {
        return ownerService.getAll();
    }

    @GetMapping("/{id}")
    public Owner getById(@PathVariable Long id) {
        return ownerService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Owner update(@PathVariable Long id, @Valid @RequestBody Owner owner) {
        owner.setId(id);
        return ownerService.save(owner);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        ownerService.delete(id);
    }
}
