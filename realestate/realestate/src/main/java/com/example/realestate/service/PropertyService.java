package com.example.realestate.service;

import com.example.realestate.entity.Property;
import com.example.realestate.entity.PropertyStatus;
import com.example.realestate.repository.PropertyRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PropertyService {

    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // CRUD
    public Property save(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    public Property getById(Long id) {
        return propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
    }

    public void delete(Long id) {
        propertyRepository.deleteById(id);
    }


    // --- CUSTOM QUERY METHODS ---

    public List<Property> findByAgent(Long agentId) {
        return propertyRepository.findByAgentId(agentId);
    }

    public List<Property> findByFeature(String featureName) {
        return propertyRepository.findByFeatureName(featureName);
    }

    public List<Property> findByOwner(Long ownerId) {
        return propertyRepository.findByOwnerId(ownerId);
    }

    public List<Property> findAvailable() {
        return propertyRepository.findByStatus(PropertyStatus.AVAILABLE);
    }

    public List<Property> findInPriceRange(Double min, Double max) {
        return propertyRepository.findByPriceBetween(min, max);
    }

    public List<Property> findWithoutAppointments() {
        return propertyRepository.findPropertiesWithNoAppointments();
    }
}
