package ec.ecutb.JPAAssignment.Data;

import ec.ecutb.JPAAssignment.Model.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

    Ingredient findByIngredientNameIgnoreCase(String ingredient);
    List<Ingredient> findByIngredientNameContainingIgnoreCase(String string);
}
