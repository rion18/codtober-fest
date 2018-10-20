package com.rion18.stackbuilders.codtoberfest.rest.controller;

import com.rion18.stackbuilders.codtoberfest.exception.ResourceNotFoundException;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import com.rion18.stackbuilders.codtoberfest.rest.representation.OrderHeaderRepresentation;
import com.rion18.stackbuilders.codtoberfest.rest.representation.OrderSummary;
import com.rion18.stackbuilders.codtoberfest.rest.representation.StatisticsRepresentation;
import com.rion18.stackbuilders.codtoberfest.rest.service.OrderService;
import com.rion18.stackbuilders.codtoberfest.rest.service.StatisticsService;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    StatisticsRepresentation statisticsRepresentation = new StatisticsRepresentation();
    statisticsRepresentation.setAverageTotal(new BigDecimal(18));
    statisticsRepresentation.setMostValuableCustomer("john");
    return statisticsRepresentation;
  }

}
