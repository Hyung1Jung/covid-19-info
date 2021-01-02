package com.covid19.service;

import com.covid19.domain.entity.Report;
import com.covid19.domain.repository.DayRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DayServiceTest {

    @InjectMocks
    private DayService dayService;

    @Mock
    private DayRepository dayRepository;


    @Test
    void getConfirmByStateDt() {
        when(dayRepository.findByStateDate("20201220"))
                .thenReturn(Lists.newArrayList(new Report("20201220",49661)));

        List<Report> result = dayService.getConfirm("20201220");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getConfirmNumber()).isEqualTo(49661);
    }

}