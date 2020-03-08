package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;
import ec.ecutb.JPAAssignment.Model.Entity.RecipeIngredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, String> {
    Optional<RecipeIngredient> findByIngredient(Ingredient ingredient);
}
