package ec.ecutb.JPAAssignment.Service.Interfaces;

import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeIngredient;
import ec.ecutb.JPAAssignment.Model.Measurement;
import org.springframework.transaction.annotation.Transactional;

public interface RecipeIngredientCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeIngredient createAndSave(Ingredient ingredient, Double amount, Measurement measurement);
}
