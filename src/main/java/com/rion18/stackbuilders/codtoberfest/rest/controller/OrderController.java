package com.rion18.stackbuilders.codtoberfest.rest.controller;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import com.rion18.stackbuilders.codtoberfest.rest.representation.CreateOrderRequest;
import com.rion18.stackbuilders.codtoberfest.rest.representation.CreateOrderResponse;
import com.rion18.stackbuilders.codtoberfest.rest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  // TODO Obviously, client should send ids
  @PostMapping
  @ResponseBody
  public CreateOrderResponse hello(@RequestBody CreateOrderRequest createOrderRequest) {
    OrderHeader orderHeader = orderService.createOrder(createOrderRequest);
    return new CreateOrderResponse(orderHeader);
  }

}
