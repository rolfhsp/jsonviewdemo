package com.example.jsonviewdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.jsonviewdemo.api.ApiAgent;
import com.example.jsonviewdemo.model.AgentMapper;
import com.example.jsonviewdemo.repository.AgentJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    private final AgentJpaRepository agentJpaRepository;

    public AgentService(AgentJpaRepository agentJpaRepository) {
        this.agentJpaRepository = agentJpaRepository;
    }

    public Optional<ApiAgent> getAgent(Long id) {
        return agentJpaRepository.findById(id).map(AgentMapper.toApiAgentDto);
    }

    public List<? extends ApiAgent> getAgents() {
        return agentJpaRepository.findAll().stream().map(AgentMapper.toApiAgentDto).collect(Collectors.toList());
    }
}
