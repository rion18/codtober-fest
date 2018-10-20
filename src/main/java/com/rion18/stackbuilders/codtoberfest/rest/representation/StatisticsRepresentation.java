package com.rion18.stackbuilders.codtoberfest.rest.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

public class StatisticsRepresentation {

  @JsonProperty("average_order_total")
  private BigDecimal averageTotal;

  @JsonProperty("most_valuable_customer")
  private String mostValuableCustomer;

  @JsonProperty("popular_ingredients")
  private List<String> mostPopularIngredients;

  public BigDecimal getAverageTotal() {
    return averageTotal;
  }

  public void setAverageTotal(BigDecimal averageTotal) {
    this.averageTotal = averageTotal;
  }

  public String getMostValuableCustomer() {
    return mostValuableCustomer;
  }

  public void setMostValuableCustomer(String mostValuableCustomer) {
    this.mostValuableCustomer = mostValuableCustomer;
  }

  public List<String> getMostPopularIngredients() {
    return mostPopularIngredients;
  }

  public void setMostPopularIngredients(List<String> mostPopularIngredients) {
    this.mostPopularIngredients = mostPopularIngredients;
  }
}
