package com.rion18.stackbuilders.codtoberfest.persistence.repository;

import com.rion18.stackbuilders.codtoberfest.persistence.entity.IngredientDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDetailRepository extends CrudRepository<IngredientDetail, Long> {

}
