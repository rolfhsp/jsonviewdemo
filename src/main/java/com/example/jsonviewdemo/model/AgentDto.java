package com.example.jsonviewdemo.model;


import com.example.jsonviewdemo.api.ApiAgent;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data @AllArgsConstructor
public class AgentDto implements ApiAgent {

    @JsonView(JsonViews.Basic.class)
    private Long id;

    @JsonView(JsonViews.Basic.class)
    private String codeName;

    @JsonView(JsonViews.MView.class)
    private String realName;

    @JsonView(JsonViews.MView.class)
    private Boolean licenseToKill;

    @JsonView(JsonViews.QView.class)
    private String vehicle;

    @JsonView(JsonViews.QView.class)
    private String weapon;

    @JsonView({JsonViews.MView.class, JsonViews.QView.class})
    private String phrase;

    @JsonView(JsonViews.MView.class)
    private String mission;
}
