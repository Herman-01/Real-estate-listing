package com.example.realestate.service;

import com.example.realestate.entity.Owner;
import com.example.realestate.repository.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    public Owner getById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    public void delete(Long id) {
        ownerRepository.deleteById(id);
    }
}
