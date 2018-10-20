package com.rion18.stackbuilders.codtoberfest.rest.representation;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class OrderHeaderRepresentation {

  private long id;
  private String name;
  private String address;
  private String phone;
  private String size;
  private List<String> ingredients;
  private BigDecimal total;

  public OrderHeaderRepresentation() {

  }

  public OrderHeaderRepresentation(OrderHeader orderHeader) {
    this(orderHeader, null);
  }

  public OrderHeaderRepresentation(OrderHeader orderHeader, BigDecimal total) {
    this.id = orderHeader.getId();
    this.name = orderHeader.getFullName();
    this.address = orderHeader.getAddress();
    this.phone = orderHeader.getPhone();
    // TODO change when API supports more orderDetails.
    this.size = orderHeader.getOrderDetails().get(0).getSizeName();
    this.ingredients = orderHeader.getOrderDetails().get(0).getIngredientDetails().stream()
        .map(ingredientDetail -> ingredientDetail.getName() + " " + ingredientDetail.getPrice())
        .collect(Collectors.toList());
    this.total = total;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public List<String> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<String> ingredients) {
    this.ingredients = ingredients;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }
}