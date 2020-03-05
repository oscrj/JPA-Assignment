package ec.ecutb.JPAAssignment.Service.Interfaces;

import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;
import org.springframework.transaction.annotation.Transactional;

public interface IngredientCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    Ingredient createAndSave(String ingredientName);
}
