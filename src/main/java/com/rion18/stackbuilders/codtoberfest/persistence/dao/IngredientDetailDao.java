package com.rion18.stackbuilders.codtoberfest.persistence.dao;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.IngredientDetail;
import com.rion18.stackbuilders.codtoberfest.persistence.repository.IngredientDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientDetailDao extends GenericDao<IngredientDetail, Long> {

  @Autowired
  public IngredientDetailDao(IngredientDetailRepository ingredientDetailRepository) {
    super(ingredientDetailRepository);
  }
}
