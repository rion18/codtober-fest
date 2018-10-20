package com.rion18.stackbuilders.codtoberfest.rest.controller;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.Ingredient;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.IngredientRepository;
import com.rion18.stackbuilders.codtoberfest.rest.representation.CreateOrderRequest;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {

  @Autowired
  public IngredientRepository ingredientRepository;

//  {
//    "name": "Sebastian",
//      "address": "10 de Agosto y Rumipamba",
//      "phone": "0969074930",
//      "size": "Medium",
//      "ingredients": [
//    "Extra cheese",
//        "Pineapple",
//        "Onions"
//    ]
//  }

  @PostMapping
  public String hello(CreateOrderRequest createOrderRequest) {
    Ingredient ingredient = new Ingredient();
    ingredient.setName("HOLA");
    ingredient.setPrice(new BigDecimal(1));
    ingredientRepository.save(ingredient);
    Iterable<Ingredient> ingredients = ingredientRepository.findAll();
    StringBuilder total = new StringBuilder();
    ingredients.forEach(ingredientIterable ->
        total.append(ingredientIterable.getId())
            .append(" ")
            .append(ingredientIterable.getName())
            .append(" ")
            .append(ingredientIterable.getPrice())
    );
    return total.toString();
  }

}
