package com.example.jsonviewdemo.controller;

import java.util.List;

import com.example.jsonviewdemo.api.ApiAgent;
import com.example.jsonviewdemo.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping(value="/api/agent/{id}")
    public ResponseEntity<ApiAgent> getAgent(@PathVariable Long id) {

        return ResponseEntity.ok(agentService.getAgent(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found")));
    }

    @GetMapping(value="/api/agents")
    public ResponseEntity<List<? extends ApiAgent>> getAgents() {

        return ResponseEntity.ok(agentService.getAgents());
    }

}
