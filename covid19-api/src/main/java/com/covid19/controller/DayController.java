package com.covid19.controller;


import com.covid19.domain.entity.Report;
import com.covid19.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DayController {
    private final DayService dayService;

    @Autowired
    public DayController(DayService todayDataService) {
        this.dayService = todayDataService;
    }

    @GetMapping("/confirm")
    public List<Report> getConfirm(@RequestParam("date") String date){
        dayService.save();
        return dayService.getConfirm(date);

    }

}
