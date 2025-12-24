package com.example.realestate.repository;

import com.example.realestate.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface  PropertyRepository extends JpaRepository<Property, Long> {

    // 1. Find properties listed by an agent
    List<Property> findByAgentId(Long agentId);

    // 2. Find properties with a specific feature
    @Query("SELECT p FROM Property p JOIN p.features f WHERE f.name = :featureName")
    List<Property> findByFeatureName(String featureName);

    // 3. Find properties owned by owner
    List<Property> findByOwnerId(Long ownerId);

    // 4. Find available properties
    List<Property> findByStatus(com.example.realestate.entity.PropertyStatus status);

    // 5. Find properties in price range
    List<Property> findByPriceBetween(Double min, Double max);

    // 6. Properties with no appointments
    @Query("SELECT p FROM Property p WHERE p.id NOT IN (SELECT ap.property.id FROM ViewingAppointment ap)")
    List<Property> findPropertiesWithNoAppointments();
}
