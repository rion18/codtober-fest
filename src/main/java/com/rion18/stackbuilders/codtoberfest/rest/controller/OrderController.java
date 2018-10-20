package com.rion18.stackbuilders.codtoberfest.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  @GetMapping("/hello")
  public String hello() {
    return "hello";
  }

}
