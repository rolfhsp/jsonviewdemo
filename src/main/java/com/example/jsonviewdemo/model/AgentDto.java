package com.example.jsonviewdemo.model;


import com.example.jsonviewdemo.api.ApiAgent;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class AgentDto implements ApiAgent {
    private Long id;
    private String codeName;
    private String realName;
    private Boolean licenseToKill;
    private String vehicle;
    private String weapon;
    private String phrase;
    private String mission;
}
