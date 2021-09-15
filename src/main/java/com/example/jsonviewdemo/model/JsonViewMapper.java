package com.example.jsonviewdemo.model;

import org.springframework.http.converter.json.MappingJacksonValue;

public class JsonViewMapper {

    public static MappingJacksonValue map2JsonView(Object o, String role) {
        MappingJacksonValue wrapper = new MappingJacksonValue(o);

        switch (role.toLowerCase()) {
            case "m":
                wrapper.setSerializationView(JsonViews.MView.class);
                break;
            case "q":
                wrapper.setSerializationView(JsonViews.QView.class);
                break;
            case "hacker":
                break;
            default:
                wrapper.setSerializationView(JsonViews.Basic.class);
        }
        return wrapper;
    }
}
