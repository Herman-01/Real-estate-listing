package com.example.realestate.service;

import com.example.realestate.entity.Feature;
import com.example.realestate.repository.FeatureRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public Feature save(Feature feature) {
        return featureRepository.save(feature);
    }

    public List<Feature> getAll() {
        return featureRepository.findAll();
    }

    public Feature getById(Long id) {
        return featureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found"));
    }

    public void delete(Long id) {
        featureRepository.deleteById(id);
    }
}
