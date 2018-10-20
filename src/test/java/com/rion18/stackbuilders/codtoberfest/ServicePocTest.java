package com.rion18.stackbuilders.codtoberfest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.rion18.stackbuilders.codtoberfest.persistence.dao.IngredientDao;
import com.rion18.stackbuilders.codtoberfest.persistence.entity.Ingredient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * POC Test to indicate we can easily mock Spring's @Services
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ServicePocTest {

  @Mock
  private IngredientDao ingredientDao;

  @Test
  public void ingredientDaoIsMocked() {
    Ingredient ingredient = new Ingredient();
    ingredient.setName("Test ingredient");
    when(ingredientDao.findById(anyLong())).thenReturn(ingredient);
    Ingredient fetchedIngredient = ingredientDao.findById(1L);
    assertNotNull(fetchedIngredient);
    assertEquals("IngredientDao mock has expected value",
        ingredient.getName(), fetchedIngredient.getName());
  }

}
