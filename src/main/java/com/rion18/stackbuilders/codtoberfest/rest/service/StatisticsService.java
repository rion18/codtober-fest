package com.rion18.stackbuilders.codtoberfest.rest.service;

import com.rion18.stackbuilders.codtoberfest.persistence.dao.StatisticsDao;
import com.rion18.stackbuilders.codtoberfest.rest.representation.StatisticsRepresentation;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

  private final StatisticsDao statisticsDao;

  @Autowired
  public StatisticsService(StatisticsDao statisticsDao) {
    this.statisticsDao = statisticsDao;
  }

  public StatisticsRepresentation fetchStatistics() {
    StatisticsRepresentation statisticsRepresentation = new StatisticsRepresentation();
    statisticsRepresentation.setAverageTotal(new BigDecimal(18));
    statisticsRepresentation.setMostValuableCustomer("john");
    List<String> ingredients = new ArrayList<>();
    ingredients.add("first");
    ingredients.add("2nd");
    ingredients.add("3rd");
    statisticsRepresentation.setMostPopularIngredients(ingredients);
    return statisticsRepresentation;
  }

}
