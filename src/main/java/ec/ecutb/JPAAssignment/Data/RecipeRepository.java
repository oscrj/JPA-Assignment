package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findByRecipeNameContainingIgnoreCase(String string);

    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeIngredientList recipeIngredient WHERE recipeIngredient.ingredient.ingredientName = :ingredientName")
    List<Recipe> findRecipeByIngredientName(@Param("ingredientName") String ingredientName);

    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeCategoryList recipeCategoryList WHERE recipeCategory.category = :category")
    List<Recipe> findRecipeByCategory(@Param("category") String category);

    @Query("SELECT r FROM Recipe r JOIN FETCH r.recipeCategoryList recipeCategoryList WHERE recipeCategory.category = :category")
    List<Recipe> findRecipeByCategories(@Param("category") String...category);

}
