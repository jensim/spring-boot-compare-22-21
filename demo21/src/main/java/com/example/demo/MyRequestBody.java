package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MyRequestBody {
    @JsonProperty
    private String foo1;
    @JsonProperty
    private String foo2;
    @JsonProperty
    private String foo3;
    @JsonProperty
    private String foo4;
    @JsonProperty
    private String foo5;
    @JsonProperty
    private String foo6;
    @JsonProperty
    private String foo7;
    @JsonProperty
    private String foo8;
    @JsonProperty
    private String foo9;
}
