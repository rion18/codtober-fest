package com.rion18.stackbuilders.codtoberfest.persistence.dao;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailDao extends GenericDao<OrderDetail, Long> {

  @Autowired
  public OrderDetailDao(OrderDetailRepository orderDetailRepository) {
    super(orderDetailRepository);
  }
}
