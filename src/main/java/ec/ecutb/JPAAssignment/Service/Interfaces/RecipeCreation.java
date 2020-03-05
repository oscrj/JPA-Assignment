package ec.ecutb.JPAAssignment.Service.Interfaces;

import ec.ecutb.JPAAssignment.Model.Entity.Recipe;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeCategory;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeIngredient;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeInstruction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RecipeCreation {

    @Transactional(rollbackFor = RuntimeException.class)
    Recipe saveAndCreate(String recipeName, List<RecipeIngredient> recipeIngredientList, RecipeInstruction instruction, List<RecipeCategory> recipeCategoryList);
}
