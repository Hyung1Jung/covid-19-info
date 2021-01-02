package com.covid19.domain.repository;

import com.covid19.domain.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayRepository extends JpaRepository<Report, Integer> {
    List<Report> findByStateDate(String date);
}
