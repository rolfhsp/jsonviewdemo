package com.example.jsonviewdemo.controller;

import java.util.List;

import com.example.jsonviewdemo.api.ApiAgent;
import com.example.jsonviewdemo.model.JsonViews;
import com.example.jsonviewdemo.service.AgentService;
import com.fasterxml.jackson.annotation.JsonView;
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




    @JsonView(JsonViews.Basic.class)
    @GetMapping(value="/api/b/agent/{id}")
    public ResponseEntity<ApiAgent> getAgentBasic(@PathVariable Long id) {

        return ResponseEntity.ok(agentService.getAgent(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found")));
    }

    @JsonView(JsonViews.MView.class)
    @GetMapping(value="/api/m/agent/{id}")
    public ResponseEntity<ApiAgent> getAgentForM(@PathVariable Long id) {

        return ResponseEntity.ok(agentService.getAgent(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found")));
    }

    @JsonView(JsonViews.QView.class)
    @GetMapping(value="/api/q/agent/{id}")
    public ResponseEntity<ApiAgent> getAgentForQ(@PathVariable Long id) {

        return ResponseEntity.ok(agentService.getAgent(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agent not found")));
    }

    @JsonView(JsonViews.Basic.class)
    @GetMapping(value="/api/b/agents")
    public ResponseEntity<List<? extends ApiAgent>> getAgentsBasic() {

        return ResponseEntity.ok(agentService.getAgents());
    }

    @JsonView(JsonViews.MView.class)
    @GetMapping(value="/api/m/agents")
    public ResponseEntity<List<? extends ApiAgent>> getAgentsForM() {

        return ResponseEntity.ok(agentService.getAgents());
    }

    @JsonView(JsonViews.QView.class)
    @GetMapping(value="/api/q/agents")
    public ResponseEntity<List<? extends ApiAgent>> getAgentsForQ() {

        return ResponseEntity.ok(agentService.getAgents());
    }


}
