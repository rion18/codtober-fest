package com.rion18.stackbuilders.codtoberfest.rest.representation;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.IngredientDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderSummary {

  private long id;
  private String name;
  private String address;
  private String phone;
  private BigDecimal total;

  public OrderSummary(OrderHeader orderHeader, BigDecimal total) {
    this.id = orderHeader.getId();
    this.name = orderHeader.getFullName();
    this.address = orderHeader.getAddress();
    this.phone = orderHeader.getPhone();
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

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }
}
