package com.covid19.controller;

import com.covid19.domain.entity.Report;
import com.covid19.exception.DayNotFoundException;
import com.covid19.service.DayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DayController.class)
class DayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DayService dayService;

    @Test
    void getConfirm() throws Exception {
        List<Report> itemEntities = new ArrayList<>();
        itemEntities.add(Report.builder()
                .stateDate("20201220")
                .confirmNumber(49661)
                .build());

       given(dayService.getConfirm("20201220")).willReturn(itemEntities);

        mockMvc.perform(
                get("/api/confirm").param("date", "20201220"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[0].stateDate").value("20201220"))
                .andExpect(jsonPath("[0].confirmNumber").value(49661));
    }

    @Test
    public void getConfrimNotFound() throws Exception {
        given(dayService.getConfirm("20191231"))
                .willThrow(new DayNotFoundException("20191231"));

        mockMvc.perform(
                get("/api/confirm").param("date", "20191231"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("{}"));
    }


}