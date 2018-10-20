package com.rion18.stackbuilders.codtoberfest.persistence.repository;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
