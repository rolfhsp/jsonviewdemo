package com.example.jsonviewdemo.repository;

import com.example.jsonviewdemo.model.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentJpaRepository extends JpaRepository<AgentEntity, Long> {
}
