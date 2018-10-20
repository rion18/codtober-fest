package com.rion18.stackbuilders.codtoberfest.rest.representation;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.IngredientDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderResponse {

  private long id;
  private String fullName;
  private String address;
  private String phone;
  private List<OrderDetailRepresentation> orderDetails;

  public CreateOrderResponse(OrderHeader orderHeader) {
    this.id = orderHeader.getId();
    this.fullName = orderHeader.getFullName();
    this.address = orderHeader.getAddress();
    this.phone = orderHeader.getPhone();
    this.orderDetails = new ArrayList<>();
    for (OrderDetail orderDetail : orderHeader.getOrderDetails()) {
      OrderDetailRepresentation detailRepresentation = new OrderDetailRepresentation();
      detailRepresentation.id = orderDetail.getId();
      detailRepresentation.sizeName = orderDetail.getSizeName();
      detailRepresentation.sizePrice = orderDetail.getSizePrice();
      detailRepresentation.quantity = orderDetail.getQuantity();
      detailRepresentation.ingredientDetails = new ArrayList<>();
      for (IngredientDetail ingredientDetail : orderDetail.getIngredientDetails()) {
        IngredientDetailRepresentation ingredientRepresentation = new IngredientDetailRepresentation();
        ingredientRepresentation.id = ingredientDetail.getId();
        ingredientRepresentation.name = ingredientDetail.getName();
        ingredientRepresentation.price = ingredientDetail.getPrice();
        detailRepresentation.ingredientDetails.add(ingredientRepresentation);
      }
      orderDetails.add(detailRepresentation);
    }
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
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

  public List<OrderDetailRepresentation> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetailRepresentation> orderDetails) {
    this.orderDetails = orderDetails;
  }

  private static class OrderDetailRepresentation {

    private Long id;
    private String sizeName;
    private BigDecimal sizePrice;
    private int quantity;
    private OrderHeader orderHeader;
    private List<IngredientDetailRepresentation> ingredientDetails;

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

    public List<IngredientDetailRepresentation> getIngredientDetails() {
      return ingredientDetails;
    }

    public void setIngredientDetails(
        List<IngredientDetailRepresentation> ingredientDetails) {
      this.ingredientDetails = ingredientDetails;
    }
  }

  private static class IngredientDetailRepresentation {

    private Long id;
    private String name;
    private BigDecimal price;

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
  }
}
