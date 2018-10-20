package com.rion18.stackbuilders.codtoberfest.persistence.dao;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.Ingredient;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.IngredientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientDao extends GenericDao<Ingredient, Long> {

  @Autowired
  public IngredientDao(IngredientRepository ingredientRepository) {
    super(ingredientRepository);
  }

  public List<Ingredient> findByNames(List<String> names) {
    return ((IngredientRepository) repository).findByNames(names);
  }

}
