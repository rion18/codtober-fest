package com.rion18.stackbuilders.codtoberfest.rest.controller;

import com.rion18.stackbuilders.codtoberfest.exception.ResourceNotFoundException;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import com.rion18.stackbuilders.codtoberfest.rest.representation.OrderHeaderRepresentation;
import com.rion18.stackbuilders.codtoberfest.rest.representation.OrderSummary;
import com.rion18.stackbuilders.codtoberfest.rest.service.OrderService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  // TODO Obviously, client should send ids
  @PostMapping
  public OrderHeaderRepresentation createOrderResponse(@RequestBody OrderHeaderRepresentation createOrderRequest) {
    OrderHeader orderHeader = orderService.createOrder(createOrderRequest);
    return new OrderHeaderRepresentation(orderHeader);
  }

  // TODO Obviously, client should send ids
  @GetMapping
  public List<OrderSummary> fetchAllOrders() {
    List<OrderHeader> orders = orderService.findAllOrders();
    if (CollectionUtils.isEmpty(orders)) {
      throw new ResourceNotFoundException("No orders found");
    }
    return orders.stream()
        .map(orderHeader -> new OrderSummary(orderHeader, orderService.findTotal(orderHeader)))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public OrderHeaderRepresentation fetchOrder(@PathVariable long id) {
    OrderHeader orderHeader = orderService.findOrderById(id);
    if (orderHeader == null) {
      throw new ResourceNotFoundException("Order with id " + id + " not found");
    }
    return new OrderHeaderRepresentation(orderHeader, orderService.findTotal(orderHeader));
  }

}
