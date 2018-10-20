package com.rion18.stackbuilders.codtoberfest.persistence.dao;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.OrderHeader;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHeaderDao extends GenericDao<OrderHeader, Long> {

  @Autowired
  public OrderHeaderDao(OrderHeaderRepository orderHeaderRepository) {
    super(orderHeaderRepository);
  }
}
