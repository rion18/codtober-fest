package com.rion18.stackbuilders.codtoberfest.persistence.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_header")
public class OrderHeader {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "fullName", nullable = false, length = 128)
  private String fullName;

  @Column(name = "address", nullable = false, length = 128)
  private String address;

  @Column(name = "phone", nullable = false, length = 32)
  private String phone;

  @OneToMany(mappedBy = "orderHeader", fetch = FetchType.EAGER)
  private List<OrderDetail> orderDetails;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public List<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }
}
