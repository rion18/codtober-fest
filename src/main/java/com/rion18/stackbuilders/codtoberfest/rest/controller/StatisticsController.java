package com.rion18.stackbuilders.codtoberfest.rest.controller;

import com.rion18.stackbuilders.codtoberfest.rest.representation.StatisticsRepresentation;
import com.rion18.stackbuilders.codtoberfest.rest.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

  private final StatisticsService statisticsService;

  @Autowired
  public StatisticsController(StatisticsService statisticsService) {
    this.statisticsService = statisticsService;
  }

  @GetMapping
  public StatisticsRepresentation fetchStatistics() {
    return statisticsService.fetchStatistics();
  }

}
