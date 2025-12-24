package com.example.realestate.service;

import com.example.realestate.entity.Buyer;
import com.example.realestate.repository.BuyerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BuyerService {

    private final BuyerRepository buyerRepository;

    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    public List<Buyer> getAll() {
        return buyerRepository.findAll();
    }

    public Buyer getById(Long id) {
        return buyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buyer not found"));
    }

    public void delete(Long id) {
        buyerRepository.deleteById(id);
    }
}
