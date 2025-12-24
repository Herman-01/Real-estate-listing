package com.example.realestate.controller;

import com.example.realestate.entity.Property;
import com.example.realestate.service.PropertyService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    // CREATE
    @PostMapping("/create")
    public Property create(@Valid @RequestBody Property property) {
        return propertyService.save(property);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Property> getAll() {
        return propertyService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Property getById(@PathVariable Long id) {
        return propertyService.getById(id);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public Property update(@PathVariable Long id, @Valid @RequestBody Property property) {
        property.setId(id);
        return propertyService.save(property);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        propertyService.delete(id);
    }

    // ---------------- CUSTOM QUERIES ---------------------

    // 1. Properties by agent
    @GetMapping("/by-agent/{agentId}")
    public List<Property> getByAgent(@PathVariable Long agentId) {
        return propertyService.findByAgent(agentId);
    }

    // 2. Properties with a given feature
    @GetMapping("/by-feature/{featureName}")
    public List<Property> getByFeature(@PathVariable String featureName) {
        return propertyService.findByFeature(featureName);
    }

    // 3. Properties owned by an owner
    @GetMapping("/by-owner/{ownerId}")
    public List<Property> getByOwner(@PathVariable Long ownerId) {
        return propertyService.findByOwner(ownerId);
    }

    // 4. Available properties
    @GetMapping("/available")
    public List<Property> getAvailable() {
        return propertyService.findAvailable();
    }

    // 5. Properties in price range
    @GetMapping("/price-range")
    public List<Property> getInPriceRange(
            @RequestParam Double min,
            @RequestParam Double max
    ) {
        return propertyService.findInPriceRange(min, max);
    }

    // 6. Properties with no appointments
    @GetMapping("/no-appointments")
    public List<Property> getWithNoAppointments() {
        return propertyService.findWithoutAppointments();
    }
}
