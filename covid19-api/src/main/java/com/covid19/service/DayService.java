package com.covid19.service;

import com.covid19.controller.dto.ReportDto;
import com.covid19.domain.caller.CovidJson;
import com.covid19.domain.entity.Report;
import com.covid19.domain.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DayService {

    private final CovidJson covidJson;
    private final DayRepository dayRepository;

    @Autowired
    public DayService(CovidJson covidJson, DayRepository dayRepository) {
        this.covidJson = covidJson;
        this.dayRepository = dayRepository;
    }

    @Transactional
    public List<Report> getConfirm(String date) {
        return dayRepository.findByStateDate(date);
    }

    @Transactional
    public void save() {
        ReportDto item = new ReportDto();
        dayRepository.saveAll(item.toEntity(covidJson.jsonPrettyPrintString().items.item));
    }

}
