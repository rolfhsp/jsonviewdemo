package com.example.jsonviewdemo.model;

import java.util.function.Function;

public interface AgentMapper {
    Function<AgentEntity, AgentDto> toApiAgentDto = agentEntity -> new AgentDto(
            agentEntity.getId(),
            agentEntity.getCodeName(),
            agentEntity.getRealName(),
            agentEntity.getLicenseToKill(),
            agentEntity.getVehicle(),
            agentEntity.getWeapon(),
            agentEntity.getPhrase(),
            agentEntity.getMission());
}
