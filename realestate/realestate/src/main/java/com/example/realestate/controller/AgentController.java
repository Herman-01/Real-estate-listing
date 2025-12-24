package com.example.realestate.controller;

import com.example.realestate.entity.Agent;
import com.example.realestate.service.AgentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/create")
    public Agent create(@Valid @RequestBody Agent agent) {
        return agentService.save(agent);
    }

    @GetMapping("/all")
    public List<Agent> getAll() {
        return agentService.getAll();
    }

    @GetMapping("/{id}")
    public Agent getById(@PathVariable Long id) {
        return agentService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Agent update(@PathVariable Long id, @Valid @RequestBody Agent agent) {
        agent.setId(id);
        return agentService.save(agent);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        agentService.delete(id);
    }
}
