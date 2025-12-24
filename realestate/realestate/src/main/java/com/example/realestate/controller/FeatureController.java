package com.example.realestate.controller;

import com.example.realestate.entity.Feature;
import com.example.realestate.service.FeatureService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @PostMapping("/create")
    public Feature create(@Valid @RequestBody Feature feature) {
        return featureService.save(feature);
    }

    @GetMapping("/all")
    public List<Feature> getAll() {
        return featureService.getAll();
    }

    @GetMapping("/{id}")
    public Feature getById(@PathVariable Long id) {
        return featureService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Feature update(@PathVariable Long id, @Valid @RequestBody Feature feature) {
        feature.setId(id);
        return featureService.save(feature);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        featureService.delete(id);
    }
}
