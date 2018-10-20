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
      OrderDetailRepresentation representation = new OrderDetailRepresentation();
      representation.id = orderDetail.getId();
      representation.sizeName = orderDetail.getSizeName();
      representation.sizePrice = orderDetail.getSizePrice();
      representation.quantity = orderDetail.getQuantity();
      for (IngredientDetail ingredientDetail : orderDetail.getIngredientDetails()) {
        IngredientDetailRepresentation ingredientRepresentation = new IngredientDetailRepresentation();
        ingredientRepresentation.id = ingredientDetail.getId();
        ingredientRepresentation.name = ingredientDetail.getName();
        ingredientRepresentation.price = ingredientDetail.getPrice();
      }
    }
  }

  private static class OrderDetailRepresentation {

    private Long id;
    private String sizeName;
    private BigDecimal sizePrice;
    private int quantity;
    private OrderHeader orderHeader;
    private List<IngredientDetailRepresentation> ingredientDetails;

  }

  private static class IngredientDetailRepresentation {

    private Long id;
    private String name;
    private BigDecimal price;

  }
}
