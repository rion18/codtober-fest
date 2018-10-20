package com.rion18.stackbuilders.codtoberfest.rest.service;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.Ingredient;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.IngredientDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.Size;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.IngredientDetailRepository;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.IngredientRepository;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.OrderDetailRepository;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.OrderHeaderRepository;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.SizeRepository;
import com.rion18.stackbuilders.codtoberfest.rest.representation.CreateOrderRequest;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  private IngredientRepository ingredientRepository;

  @Autowired
  private SizeRepository sizeRepository;

  @Autowired
  private OrderHeaderRepository orderHeaderRepository;

  @Autowired
  private OrderDetailRepository orderDetailRepository;

  @Autowired
  private IngredientDetailRepository ingredientDetailRepository;

  public void createOrder(CreateOrderRequest createOrderRequest) {
    Size size = fetchSizeByName(createOrderRequest.getSize());
    List<Ingredient> ingredients = fetchIngredientsByNames(createOrderRequest.getIngredients());

    OrderHeader orderHeader = new OrderHeader();
    orderHeader.setFullName(createOrderRequest.getName());
    orderHeader.setAddress(createOrderRequest.getAddress());
    orderHeader.setPhone(createOrderRequest.getPhone());

    OrderDetail orderDetail = new OrderDetail();
    orderDetail.setOrderHeader(orderHeader);
    orderDetail.setQuantity(1);
    orderDetail.setSizeName(size.getName());
    orderDetail.setSizePrice(size.getPrice());

    List<IngredientDetail> ingredientDetails = ingredients.stream()
        .map(ingredient -> new IngredientDetail(orderDetail, ingredient))
        .collect(Collectors.toList());

    // TODO SAVE

  }

  private Size fetchSizeByName(String name) {
    return null;
  }

  private List<Ingredient> fetchIngredientsByNames(List<String> names) {
    return null;
  }

}
