package com.rion18.stackbuilders.codtoberfest.persistence.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IngredientDetail {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "name", nullable = false, length = 200)
  private String name;

  @Column(name = "price", nullable = false, length = 200)
  private BigDecimal price;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ORDER_DETAIL_ID", referencedColumnName = "ID")
  private OrderDetail orderDetail;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }
}
