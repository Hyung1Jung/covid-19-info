package com.covid19.controller.dto;

import com.covid19.domain.entity.Report;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class ReportDto {

    @Id
    @JsonProperty("stateDate")
    public String stateDt;        // 기준일

    @JsonProperty("decideCnt")
    public int decideCnt;     // 확진자 수


    public List<Report> toEntity(List<ReportDto> items) {
        List<Report> itemEntities = new ArrayList<>();
        int yesterdayConfirm = 0;
        for (ReportDto item : items) {
            Report itemEntity = Report.builder()
                    .stateDate(item.stateDt)
                    .confirmNumber(yesterdayConfirm - item.decideCnt)
                    .build();
            if(item.decideCnt != 0){
                yesterdayConfirm = item.decideCnt;
            }
            itemEntities.add(itemEntity);
        }
        return itemEntities;
    }
}


