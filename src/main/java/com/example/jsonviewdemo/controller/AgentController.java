package com.example.jsonviewdemo.controller;

import com.example.jsonviewdemo.model.JsonViewMapper;
import com.example.jsonviewdemo.service.AgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping(value="/api/agent/{id}")
    public ResponseEntity<MappingJacksonValue> getAgent(@PathVariable Long id, @RequestParam(name = "role", required = false, defaultValue = "") String role) {

        return ResponseEntity.ok(JsonViewMapper.map2JsonView(agentService.getAgent(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found")), role));
    }

    @GetMapping(value="/api/agents")
    public ResponseEntity<MappingJacksonValue> getAgents(@RequestParam(name = "role", required = false, defaultValue = "") String role) {

        return ResponseEntity.ok(JsonViewMapper.map2JsonView(agentService.getAgents(), role));
    }
}
