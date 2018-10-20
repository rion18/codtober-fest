package com.rion18.stackbuilders.codtoberfest.persistence.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "sizeName", nullable = false, length = 200)
  private String sizeName;

  @Column(name = "sizePrice", nullable = false)
  private BigDecimal sizePrice;

  @Column(name = "quantity", nullable = false)
  private int quantity;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ORDER_HEADER_ID", referencedColumnName = "ID")
  private OrderHeader orderHeader;

  @OneToMany(mappedBy = "orderDetail", fetch = FetchType.EAGER)
  private List<IngredientDetail> ingredientDetails;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSizeName() {
    return sizeName;
  }

  public void setSizeName(String sizeName) {
    this.sizeName = sizeName;
  }

  public BigDecimal getSizePrice() {
    return sizePrice;
  }

  public void setSizePrice(BigDecimal sizePrice) {
    this.sizePrice = sizePrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public OrderHeader getOrderHeader() {
    return orderHeader;
  }

  public void setOrderHeader(OrderHeader orderHeader) {
    this.orderHeader = orderHeader;
  }

  public List<IngredientDetail> getIngredientDetails() {
    return ingredientDetails;
  }

  public void setIngredientDetails(List<IngredientDetail> ingredientDetails) {
    this.ingredientDetails = ingredientDetails;
  }
}
