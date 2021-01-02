package com.covid19.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Items {
    @JsonProperty("decideCnt")
    public List<ReportDto> item;
}
