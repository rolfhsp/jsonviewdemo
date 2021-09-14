package com.example.jsonviewdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Table(name = "agent")
@Getter
public class AgentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codename")
    private String codeName;

    @Column(name = "realname")
    private String realName;

    @Column(name = "licensetokill")
    private Boolean licenseToKill;

    @Column(name = "vehicle")
    private String vehicle;

    @Column(name = "weapon")
    private String weapon;

    @Column(name = "phrase")
    private String phrase;

    @Column(name = "mission")
    private String mission;

}
