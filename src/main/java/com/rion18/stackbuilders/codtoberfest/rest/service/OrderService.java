package com.rion18.stackbuilders.codtoberfest.rest.service;

import com.rion18.stackbuilders.codtoberfest.exception.ApiException;
import com.rion18.stackbuilders.codtoberfest.persistence.dao.IngredientDao;
import com.rion18.stackbuilders.codtoberfest.persistence.dao.OrderHeaderDao;
import com.rion18.stackbuilders.codtoberfest.persistence.dao.SizeDao;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.Ingredient;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.IngredientDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.Size;
import com.rion18.stackbuilders.codtoberfest.rest.representation.OrderHeaderRepresentation;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final IngredientDao ingredientDao;
  private final SizeDao sizeDao;
  private final OrderHeaderDao orderHeaderDao;

  @Autowired
  public OrderService(IngredientDao ingredientDao, SizeDao sizeDao, OrderHeaderDao orderHeaderDao) {
    this.ingredientDao = ingredientDao;
    this.sizeDao = sizeDao;
    this.orderHeaderDao = orderHeaderDao;
  }

  public OrderHeader createOrder(OrderHeaderRepresentation createOrderRequest) {
    Size size = sizeDao.findByName(createOrderRequest.getSize());

    if (size == null) {
      throw new ApiException("No size on order Request");
    }

    List<Ingredient> ingredients = ingredientDao.findByNames(createOrderRequest.getIngredients());

    // TODO validate not found ingredients

    OrderHeader orderHeader = new OrderHeader();
    orderHeader.setFullName(createOrderRequest.getName());
    orderHeader.setAddress(createOrderRequest.getAddress());
    orderHeader.setPhone(createOrderRequest.getPhone());

    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setOrderHeader(orderHeader);
    orderDetail.setQuantity(1);
    orderDetail.setSizeName(size.getName());
    orderDetail.setSizePrice(size.getPrice());
    orderHeader.addOrderDetail(orderDetail);

    orderDetail.setIngredientDetails(ingredients.stream()
        .map(ingredient -> new IngredientDetail(orderDetail, ingredient))
        .collect(Collectors.toList()));
    orderHeader.setTotal(findTotal(orderHeader));
    return orderHeaderDao.save(orderHeader);
  }

  public List<OrderHeader> findAllOrders() {
    return orderHeaderDao.findAll();
  }

  public OrderHeader findOrderById(long id) {
    return orderHeaderDao.findById(id);
  }

  private BigDecimal findTotal(OrderHeader orderHeader) {
    BigDecimal total = BigDecimal.ZERO;
    for (OrderDetail orderDetail : orderHeader.getOrderDetails()) {
      total = total.add(orderDetail.getSizePrice());
      for (IngredientDetail ingredientDetail : orderDetail.getIngredientDetails()) {
        total = total.add(ingredientDetail.getPrice());
      }
    }
    return total;
  }

}
