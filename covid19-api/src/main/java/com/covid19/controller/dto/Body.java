package com.covid19.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class Body {

    @JsonInclude(JsonInclude.Include.ALWAYS)
    @JsonProperty("report")
    public Items items;

    @JsonProperty("numOfRows")
    public int numOfRows;

    @JsonProperty("pageNo")
    public int pageNo;

    @JsonProperty("totalCount")
    public int totalCount;

}
