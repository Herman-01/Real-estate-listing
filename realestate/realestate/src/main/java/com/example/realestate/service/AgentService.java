package com.example.realestate.service;

import com.example.realestate.entity.Agent;
import com.example.realestate.repository.AgentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }

    public List<Agent> getAll() {
        return agentRepository.findAll();
    }

    public Agent getById(Long id) {
        return agentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agent not found"));
    }

    public void delete(Long id) {
        agentRepository.deleteById(id);
    }
}
